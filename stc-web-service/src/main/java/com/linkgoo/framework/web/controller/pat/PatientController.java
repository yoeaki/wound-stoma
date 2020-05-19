package com.linkgoo.framework.web.controller.pat;

import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.entity.cas.Case;
import com.linkgoo.framework.web.entity.cas.CaseVo;
import com.linkgoo.framework.web.entity.dis.Disease;
import com.linkgoo.framework.web.entity.doc.Doctor;
import com.linkgoo.framework.web.service.cas.CaseService;
import com.linkgoo.framework.web.service.dis.DiseaseService;
import com.linkgoo.framework.web.service.doc.DoctorService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.linkgoo.framework.web.core.controller.BaseController;

import com.linkgoo.framework.web.service.pat.PatientService;
import com.linkgoo.framework.web.entity.pat.Patient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: patient  病人
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:02:27
 * @version 1.0
 */

@RestController("patPatientController")
@RequestMapping(value = "/api/pat/patient")
public class PatientController extends
		BaseController<Long,Patient,PatientService> {

	@Autowired
	PatientService patientService;
	@Autowired
	CaseService caseService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	DiseaseService diseaseService;

	@PostMapping("/login")
	public RestResponse login(@RequestBody Patient patient){
		Patient temp = new Patient();
		temp.setUsername(patient.getUsername());
		Patient exit = patientService.get(temp);
		if (exit == null){
			return RestResponse.fail("用户不存在,请注册");
		}

		if (!exit.getPassword().equals(patient.getPassword())){
			return RestResponse.fail("密码不正确");
		}
		Map<String,Object> user = new HashMap(16);
		user.put("id",exit.getId());
		user.put("role",exit.getRole());
		return RestResponse.success("登录成功！",user);
	}

	@PostMapping("/register")
	public RestResponse register(@RequestBody Patient patient){
		System.out.println(patient.getUsername());
		Patient temp = new Patient();
		temp.setUsername(patient.getUsername());
		Patient exit = patientService.get(temp);
		if (exit != null){
			return RestResponse.fail("用户名已存在");
		}
		//加密
//		String password = DigestUtils.md5DigestAsHex(student.getPassword().getBytes());
		//设置权限
		patient.setRole(0);
		patientService.save(patient);
		return RestResponse.success("注册成功！");
	}


	//根据病人id查看自己的病例数量
	@GetMapping("/case/{id}")
	public RestResponse getCount(@PathVariable("id") Long patientId){
		Case aCase = new Case();
		aCase.setPatientId(patientId);
		int count = caseService.count(aCase);
		return RestResponse.success(count);
	}

	//查看所有病人数量
	@GetMapping("/count")
	public RestResponse count(){
		int count = patientService.count();
		return RestResponse.success(count);
	}

	/**
	 *
	 * @Description 工具上传，对上传信息进行校验
	 * @date 2019/8/8 16:56
	 * @params [file, tool]
	 * @return org.springframework.http.ResponseEntity<?>
	 * @Exception
	 */
	@PostMapping("/uploadCase")
	public RestResponse uploadTool(@RequestParam("uploadFile") MultipartFile file, Case acase) throws IOException {

		System.out.println("file length:" + file.getBytes().length);
		System.out.println("file length2:" + file.getSize());
		if(file.getSize() > 104857600){
			return RestResponse.fail("文件过大！");
		}

		//get fileName
		String originalFilename = file.getOriginalFilename();
		acase.setCasePic(originalFilename);
		try {
			//获取文件字节
			byte[] fileBytes = file.getBytes();
			//获取内容类型
			String contentType = file.getContentType();
			System.out.println("文件类型:" + contentType);
			acase.setCasePic("文件类型");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//save
		caseService.save(acase);
		return RestResponse.success(acase);
	}

	/**
	 *
	 * @Description 根据病人id，列出医生查看过的所有病例
	 * @date 2020/4/29 18:19
	 * @params []
	 * @return com.linkgoo.framework.web.core.response.RestResponse
	 * @Exception
	 */
	@GetMapping("/list/{id}")
	public RestResponse lists(@PathVariable("id") long patientId){
		Patient patient = patientService.get(patientId);
		String realName = patient.getRealName();
		Case aCase = new Case();
		aCase.setPatientId(patientId);
		List<Case> cases = caseService.find(aCase);

		Map<Object,String> disaseMap = new HashMap<>();
		Map<Object,String> doctorMap = new HashMap<>();
		List<CaseVo> caseVos = cases.stream().map(e -> {
			CaseVo caseVo = new CaseVo();
			BeanUtils.copyProperties(e, caseVo);
			Long disaseId = e.getDisaseId();
			Long doctorId = e.getDoctorId();
			if (disaseMap.containsKey(disaseId)){
				caseVo.setDisaseName(disaseMap.get(disaseId));
			}else{
				Disease disease = diseaseService.get(e.getDisaseId());
				if(disease != null){
					disaseMap.put(disease.getId(),disease.getDiseaseName());
					caseVo.setDisaseName(disease.getDiseaseName());
				}
			}
			if (doctorMap.containsKey(doctorId)){
				caseVo.setDoctorName(doctorMap.get(doctorId));
			}else{
				Doctor doctor = doctorService.get(e.getDoctorId());
				if(doctor != null){
					doctorMap.put(doctor.getId(),doctor.getRealName());
					caseVo.setDoctorName(doctor.getRealName());
				}
			}
			caseVo.setPatientName(realName);
			System.out.println(caseVo.toString());
			return caseVo;
		}).collect(Collectors.toList());

		return RestResponse.success(caseVos);
	}



}
