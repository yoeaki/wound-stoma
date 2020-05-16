package com.linkgoo.framework.web.entity.cas;


/**
 * Title: 病历
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-16 15:17:36
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Case implements java.io.Serializable{

	/** pk，逗号分隔 */
	private String pks;

	/** id */
	private Long id;
	/** 病人id */
	private Long patientId;
	/** 医生id */
	private Long doctorId;
	/** 就诊时间 */
	@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date seeTime;
	/** 病因id */
	private Long disaseId;
	/** 诊断 */
	private String diagnosis;
	/** 建议 */
	private String recommendation;
	/** 病图 */
	private String casePic;

	/** id */
	public Long getId() {
		return id;
	}
	/** id */
	public void setId(Long id) {
		this.id=id;
	}
	/** 病人id */
	public Long getPatientId() {
		return patientId;
	}
	/** 病人id */
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
	/** 就诊时间 */
	public java.util.Date getSeeTime() {
		return seeTime;
	}
	/** 就诊时间 */
	public void setSeeTime(java.util.Date seeTime) {
		this.seeTime=seeTime;
	}
	/** 病因id */
	public Long getDisaseId() {
		return disaseId;
	}
	/** 病因id */
	public void setDisaseId(Long disaseId) {
		this.disaseId=disaseId;
	}
	/** 诊断 */
	public String getDiagnosis() {
		return diagnosis;
	}
	/** 诊断 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis=diagnosis;
	}
	/** 建议 */
	public String getRecommendation() {
		return recommendation;
	}
	/** 建议 */
	public void setRecommendation(String recommendation) {
		this.recommendation=recommendation;
	}
	/** 病图 */
	public String getCasePic() {
		return casePic;
	}
	/** 病图 */
	public void setCasePic(String casePic) {
		this.casePic=casePic;
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
