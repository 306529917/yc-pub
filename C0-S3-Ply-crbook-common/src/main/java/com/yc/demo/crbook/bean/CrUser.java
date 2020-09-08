package com.yc.demo.crbook.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class CrUser implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotEmpty(message = "请填写账号！")
    @Length(message = "账号长度必须是4~20个字符",min = 4 , max=20)
    private String account;

	@NotEmpty(message = "请填写中文名！")
    @Length(message = "中文名长度必须是4~10个字符",min = 2 , max=10)
    private String name;

	@NotEmpty(message = "请填写密碼！")
    @Length(message = "密碼长度必须是3~20个字符",min = 3 , max=20)
    private String pwd;

    private String gender;

    private String birthday;

    private String address;

    private String phone;

    private String email;

    private String school;

    private String education;

    private String profession;

    private String job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

	@Override
	public String toString() {
		return "CrUser [id=" + id + ", account=" + account + ", name=" + name + ", pwd=" + pwd + ", gender=" + gender
				+ ", birthday=" + birthday + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", school=" + school + ", education=" + education + ", profession=" + profession + ", job=" + job
				+ "]";
	}
    
}