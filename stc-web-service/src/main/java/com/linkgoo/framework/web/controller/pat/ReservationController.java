package com.linkgoo.framework.web.controller.pat;

import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.entity.doc.Doctor;
import com.linkgoo.framework.web.entity.pat.Patient;
import com.linkgoo.framework.web.entity.pat.ReservationVO;
import com.linkgoo.framework.web.service.doc.DoctorService;
import com.linkgoo.framework.web.service.pat.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import com.linkgoo.framework.web.core.controller.BaseController;

import com.linkgoo.framework.web.service.pat.ReservationService;
import com.linkgoo.framework.web.entity.pat.Reservation;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title: reservation  预约信息
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 23:27:39
 * @version 1.0
 */

@RestController("patReservationController")
@RequestMapping(value = "/api/pat/reservation")
public class ReservationController extends
		BaseController<Long,Reservation,ReservationService> {

	@Autowired
	ReservationService reservationService;
	@Autowired
	PatientService patientService;
	@Autowired
	DoctorService doctorService;

	@GetMapping("/info/{id}")
	public RestResponse getReservationById(@PathVariable("id") Long id){
		//根据id查询学员信息
		Patient patient = patientService.get(id);
		if (patient == null){
			return RestResponse.fail("无此学员");
		}

		Reservation reservation1 = new Reservation();
		reservation1.setPatientId(id);
		List<Reservation> resList = reservationService.find(reservation1);

		List<ReservationVO> collects = resList.stream().map(e -> {
			ReservationVO reservationVO = new ReservationVO();
			BeanUtils.copyProperties(e, reservationVO);
			Doctor doctor = doctorService.get(e.getDoctorId());
			reservationVO.setDoctorName(doctor.getRealName());
			reservationVO.setPatientName(patient.getRealName());
			return reservationVO;
		}).collect(Collectors.toList());


		return RestResponse.success(collects);
	}

	@GetMapping("/info/doctor/{id}")
	public RestResponse getReservationDoctorId(@PathVariable("id") Long id){
		//根据id查询学员信息
		Doctor doctor = doctorService.get(id);
		if (doctor == null){
			return RestResponse.fail("无此医生");
		}

		Reservation reservation1 = new Reservation();
		reservation1.setDoctorId(id);
		List<Reservation> resList = reservationService.find(reservation1);

		List<ReservationVO> collects = resList.stream().map(e -> {
			ReservationVO reservationVO = new ReservationVO();
			BeanUtils.copyProperties(e, reservationVO);
			Patient patient = patientService.get(e.getPatientId());
			reservationVO.setDoctorName(doctor.getRealName());
			reservationVO.setPatientName(patient.getRealName());
			return reservationVO;
		}).collect(Collectors.toList());


		return RestResponse.success(collects);
	}

	@PutMapping("/modify/res")
	public RestResponse modify(@RequestBody Reservation reservation){
		int update = reservationService.update(reservation);
		if(update==0){
			return RestResponse.fail("更新失败");
		}

		return RestResponse.success("更新成功");
	}

	@GetMapping("count")
	public RestResponse count(){
		return RestResponse.success(reservationService.count());
	}
}
