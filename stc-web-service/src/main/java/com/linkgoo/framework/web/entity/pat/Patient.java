package com.linkgoo.framework.web.entity.pat;


/**
 * Title: 病人
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:02:27
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Patient implements java.io.Serializable{

	/** pk，逗号分隔 */
	private String pks;

	/** id */
	private Long id;
	/** 用户名 */
	private String username;
	/** 真实姓名 */
	private String realName;
	/** 身份证号 */
	private String identityNumber;
	/** 密码 */
	private String password;
	/** 性别 */
	private String sex;
	/** 年龄 */
	private String age;
	/** 电话 */
	private String phone;
	/** 地址 */
	private String address;
	/** 角色 */
	private Integer role;

	/** id */
	public Long getId() {
		return id;
	}
	/** id */
	public void setId(Long id) {
		this.id=id;
	}
	/** 用户名 */
	public String getUsername() {
		return username;
	}
	/** 用户名 */
	public void setUsername(String username) {
		this.username=username;
	}
	/** 真实姓名 */
	public String getRealName() {
		return realName;
	}
	/** 真实姓名 */
	public void setRealName(String realName) {
		this.realName=realName;
	}
	/** 身份证号 */
	public String getIdentityNumber() {
		return identityNumber;
	}
	/** 身份证号 */
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber=identityNumber;
	}
	/** 密码 */
	public String getPassword() {
		return password;
	}
	/** 密码 */
	public void setPassword(String password) {
		this.password=password;
	}
	/** 性别 */
	public String getSex() {
		return sex;
	}
	/** 性别 */
	public void setSex(String sex) {
		this.sex=sex;
	}
	/** 年龄 */
	public String getAge() {
		return age;
	}
	/** 年龄 */
	public void setAge(String age) {
		this.age=age;
	}
	/** 电话 */
	public String getPhone() {
		return phone;
	}
	/** 电话 */
	public void setPhone(String phone) {
		this.phone=phone;
	}
	/** 地址 */
	public String getAddress() {
		return address;
	}
	/** 地址 */
	public void setAddress(String address) {
		this.address=address;
	}
	/** 角色 */
	public Integer getRole() {
		return role;
	}
	/** 角色 */
	public void setRole(Integer role) {
		this.role=role;
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
