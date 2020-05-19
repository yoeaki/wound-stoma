package com.linkgoo.framework.web.controller.doc;

import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.entity.cas.Case;
import com.linkgoo.framework.web.entity.cas.CaseVo;
import com.linkgoo.framework.web.entity.dis.Disease;
import com.linkgoo.framework.web.entity.pat.Patient;
import com.linkgoo.framework.web.service.cas.CaseService;
import com.linkgoo.framework.web.service.dis.DiseaseService;
import com.linkgoo.framework.web.service.pat.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.linkgoo.framework.web.core.controller.BaseController;

import com.linkgoo.framework.web.service.doc.DoctorService;
import com.linkgoo.framework.web.entity.doc.Doctor;

import javax.print.Doc;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: doctor  医师
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:11:02
 * @version 1.0
 */

@RestController("docDoctorController")
@RequestMapping(value = "/api/doc/doctor")
public class DoctorController extends
		BaseController<Long,Doctor,DoctorService> {

	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	@Autowired
	CaseService caseService;
	@Autowired
	DiseaseService diseaseService;

	@PostMapping("/login")
	public RestResponse login(@RequestBody Doctor doctor){
		Doctor temp = new Doctor();
		temp.setUsername(doctor.getUsername());
		Doctor exit = doctorService.get(temp);
		if (exit == null){
			return RestResponse.fail("用户不存在,请注册");
		}
		if (!exit.getPassword().equals(doctor.getPassword())){
			return RestResponse.fail("密码不正确");
		}

		Map<String,Object> user = new HashMap(16);
		user.put("id",exit.getId());
		user.put("role",exit.getRole());
		return RestResponse.success("登录成功！",user);
	}

	@PostMapping("/register")
	public RestResponse register(@RequestBody Doctor doctor){
		System.out.println(doctor.getUsername());
		Doctor temp = new Doctor();
		temp.setUsername(doctor.getUsername());
		Doctor exit = doctorService.get(temp);
		if (exit != null){
			return RestResponse.fail("用户名已存在");
		}

		doctor.setRole(1);
		doctorService.save(doctor);
		return RestResponse.success("注册成功！");
	}

	//根据id查医生信息
	@GetMapping("/pro/{id}")
	public RestResponse getCoachById(@PathVariable("id") long id){
		Doctor coach = doctorService.get(id);
		if (coach == null){
			return RestResponse.fail("无此人信息");
		}
		coach.setPassword(null);
		return RestResponse.success(coach);
	}

	/**
	 *
	 * @Description 根据医生id，列出医生查看过的所有病例
	 * @date 2020/4/29 18:19
	 * @params []
	 * @return com.linkgoo.framework.web.core.response.RestResponse
	 * @Exception
	 */
/*	@GetMapping("/list/{id}")
	public RestResponse lists(@PathVariable("id") long doctorId){
		Case aCase = new Case();
		aCase.setDoctorId(doctorId);
		List<Case> students = caseService.find(aCase);

		List<CaseVo> caseVos = students.stream().map(e -> {
			CaseVo caseVo = new CaseVo();
			BeanUtils.copyProperties(e, caseVo);
			Doctor doctor = doctorService.get(e.getDoctorId());
			Patient patient = patientService.get(e.getPatientId());
			Disease disease = diseaseService.get(e.getDisaseId());
			caseVo.setDisaseName(disease.getDiseaseName());
			caseVo.setDoctorName(doctor.getRealName());
			caseVo.setPatientName(patient.getRealName());
			System.out.println(caseVo.toString());
			return caseVo;
		}).collect(Collectors.toList());

		return RestResponse.success(caseVos);
	}*/


	//查看所有教练数量
//	@GetMapping("/count")
//	public RestResponse count(){
//		int count = caseService.count();
//		return RestResponse.success(count);
//	}
//
//	//根据名字查教练
//	@GetMapping("/load")
//	public RestResponse loadByName(String username){
//		Coach coach = new Coach();
//		coach.setUsername(username);
//		Coach res = coachService.get(coach);
//		res.setPassword(null);
//		return RestResponse.success(res);
//	}

	@GetMapping("count")
	public RestResponse count(){
		return RestResponse.success(doctorService.count());
	}

	@GetMapping("/list/{id}")
	public RestResponse listsforDoctor(@PathVariable("id") long doctorId){
		Doctor doctor = doctorService.get(doctorId);
		if (doctor == null){
			return RestResponse.fail("医生不存在");
		}
		String realName = doctor.getRealName();
		Case aCase = new Case();
		aCase.setDoctorId(doctorId);
		List<Case> cases = caseService.find(aCase);

		Map<Object,String> patientMap = new HashMap<>();
		Map<Object,String> disaseMap = new HashMap<>();
		List<CaseVo> caseVos = cases.stream().map(e -> {
			CaseVo caseVo = new CaseVo();
			BeanUtils.copyProperties(e, caseVo);
			Long disaseId = e.getDisaseId();
			Long patientId = e.getPatientId();
			if (disaseMap.containsKey(disaseId)){
				caseVo.setDisaseName(disaseMap.get(disaseId));
			}else{
				Disease disease = diseaseService.get(e.getDisaseId());
				if(disease != null){
					disaseMap.put(disease.getId(),disease.getDiseaseName());
					caseVo.setDisaseName(disease.getDiseaseName());
				}
			}
			if (patientMap.containsKey(patientId)){
				caseVo.setPatientName(patientMap.get(patientId));
			}else{
				Patient patient = patientService.get(e.getPatientId());
				if(patient != null){
					patientMap.put(patient.getId(),patient.getRealName());
					caseVo.setPatientName(patient.getRealName());
				}
			}
			caseVo.setDoctorName(realName);
			System.out.println(caseVo.toString());
			return caseVo;
		}).collect(Collectors.toList());

		return RestResponse.success(caseVos);
	}


}
