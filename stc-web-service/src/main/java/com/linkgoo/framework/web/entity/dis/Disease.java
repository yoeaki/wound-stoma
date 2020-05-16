package com.linkgoo.framework.web.entity.dis;


/**
 * Title: 疾病
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:05:10
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Disease implements java.io.Serializable{

	/** pk，逗号分隔 */
	private String pks;

	/** 疾病id */
	private Long id;
	/** 疾病名称 */
	private String diseaseName;

	/** 疾病id */
	public Long getId() {
		return id;
	}
	/** 疾病id */
	public void setId(Long id) {
		this.id=id;
	}
	/** 疾病名称 */
	public String getDiseaseName() {
		return diseaseName;
	}
	/** 疾病名称 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName=diseaseName;
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
