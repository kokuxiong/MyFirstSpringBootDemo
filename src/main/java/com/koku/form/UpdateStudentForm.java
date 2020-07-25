package com.koku.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class UpdateStudentForm {

	private String stu_id;
	@NotBlank(message = "student name can not be blank")
	private String stu_name;
	@NotNull(message = "student sex must be seleted")
	private String stu_sex;
	@NotBlank(message = "student birth must be input")
	private String stu_birth;
	@NotBlank(message = "please select a teacher")
	private String teacherId;
	
	public UpdateStudentForm() {
		super();
	}
	public UpdateStudentForm(String stu_id, String stu_name, String stu_sex, String stu_birth, String teacherId) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_birth = stu_birth;
		this.teacherId = teacherId;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(String stu_birth) {
		this.stu_birth = stu_birth;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public String toString() {
		return "UpdateStudentForm [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex
				+ ", stu_birth=" + stu_birth + ", teacherId=" + teacherId + "]";
	}
	
	
}
