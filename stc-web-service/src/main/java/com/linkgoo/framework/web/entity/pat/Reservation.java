package com.linkgoo.framework.web.entity.pat;


/**
 * Title: 预约信息
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-11 21:54:57
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Reservation implements java.io.Serializable{

	/** pk，逗号分隔 */
	private String pks;

	/** id */
	private Long id;
	/** 用户id */
	private Long patientId;
	/** 医生id */
	private Long doctorId;
	/** 预约时间 */
	@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date reservationTime;
	/** 备注信息 */
	private String remarks;
	/** 预约进度 */
	private String schedule;

	/** id */
	public Long getId() {
		return id;
	}
	/** id */
	public void setId(Long id) {
		this.id=id;
	}
	/** 用户id */
	public Long getPatientId() {
		return patientId;
	}
	/** 用户id */
	public void setPatientId(Long patientId) {
		this.patientId=patientId;
	}
	/** 医生id */
	public Long getDoctorId() {
		return doctorId;
	}
	/** 医生id */
	public void setDoctorId(Long doctorId) {
		this.doctorId=doctorId;
	}
	/** 预约时间 */
	public java.util.Date getReservationTime() {
		return reservationTime;
	}
	/** 预约时间 */
	public void setReservationTime(java.util.Date reservationTime) {
		this.reservationTime=reservationTime;
	}
	/** 备注信息 */
	public String getRemarks() {
		return remarks;
	}
	/** 备注信息 */
	public void setRemarks(String remarks) {
		this.remarks=remarks;
	}
	/** 预约进度 */
	public String getSchedule() {
		return schedule;
	}
	/** 预约进度 */
	public void setSchedule(String schedule) {
		this.schedule=schedule;
	}
	/** pk */
	public String getPks() {
		return pks;
	}
	/** pk */
	public void setPks(String pks) {
		this.pks = pks;
	}
}
