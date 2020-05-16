package com.linkgoo.framework.web.controller.adm;

import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.entity.cas.Case;
import com.linkgoo.framework.web.entity.dis.Disease;
import com.linkgoo.framework.web.entity.dis.DiseaseVo;
import com.linkgoo.framework.web.entity.doc.Doctor;
import com.linkgoo.framework.web.entity.pat.Patient;
import com.linkgoo.framework.web.service.cas.CaseService;
import com.linkgoo.framework.web.service.dis.DiseaseService;
import com.linkgoo.framework.web.service.doc.DoctorService;
import com.linkgoo.framework.web.service.pat.PatientService;
import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfLong;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.linkgoo.framework.web.core.controller.BaseController;

import com.linkgoo.framework.web.service.adm.AdminService;
import com.linkgoo.framework.web.entity.adm.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: admin  管理员
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:04:41
 * @version 1.0
 */

@RestController("admAdminController")
@RequestMapping(value = "/api/adm/admin")
public class AdminController extends
		BaseController<Long,Admin,AdminService> {

	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	@Autowired
	DiseaseService diseaseService;
	@Autowired
	CaseService caseService;
	@Autowired
	AdminService adminService;

	@PostMapping("/login")
	public RestResponse login(@RequestBody Admin admin){
		Admin temp = new Admin();
		temp.setUsername(admin.getUsername());
		Admin exit = adminService.get(temp);
		if (exit == null){
			return RestResponse.fail("用户不存在,请注册");
		}
		if (!exit.getPassword().equals(admin.getPassword())){
			return RestResponse.fail("密码不正确");
		}

		Map<String,Object> user = new HashMap(16);
		user.put("id",exit.getId());
		user.put("role",exit.getRole());
		return RestResponse.success("登录成功！",user);
	}
	//查看所有医生
	@GetMapping("/list/doctors")
	public RestResponse listDoctors(){
		List<Doctor> all = doctorService.findAll();
		return RestResponse.success(all);
	}

	//查看所有用户
	@GetMapping("/list/patients")
	public RestResponse listPatients(){
		List<Patient> all = patientService.findAll();
		return RestResponse.success(all);
	}

	//查看所有病例
	@GetMapping("/list/cases")
	public RestResponse listCase(){
		List<Case> all = caseService.findAll();
		return RestResponse.success(all);
	}

	//查看今日就诊人数
	@GetMapping("/see/todayCount")
	public RestResponse todayCount(){
		List<Case> all = caseService.findAll();
		return RestResponse.success(all);
	}

	//查看所有的病因人数
	@GetMapping("/case/sameCount")
	public RestResponse caseSameCount(){
		List<Case> all = caseService.findAll();
		List<DiseaseVo> diseaseVos = new ArrayList<>();
		all.stream().collect(Collectors.groupingBy(Case::getDisaseId)).forEach((k,v) -> {
			DiseaseVo diseaseVo = new DiseaseVo();
			int size = v.size();
			Disease disease = diseaseService.get(k);
			diseaseVo.setDiseaseNum(size);
			diseaseVo.setDiseaseName(disease.getDiseaseName());
			diseaseVos.add(diseaseVo);
		});
		return RestResponse.success(diseaseVos);
	}


}
