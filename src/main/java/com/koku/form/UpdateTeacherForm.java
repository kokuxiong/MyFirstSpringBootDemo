package com.koku.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class UpdateTeacherForm {

	private String tea_id;
	@NotBlank(message ="teacher name can not be blank")
	private String tea_name;
	@NotNull(message = "teacher sex must be seleted")
	private String tea_sex;
	@NotBlank(message="please select a lesson")
	private String updatedTeacherLesson;
	@NotBlank(message="teacher birth must be input")
	private String tea_birth;
	@NotBlank(message="please input something about the teacher")
	private String tea_comment;
	
	public UpdateTeacherForm() {
		super();
	}
	public UpdateTeacherForm(String tea_id, String tea_name, String tea_sex, String updatedTeacherLesson,
			String tea_birth, String tea_comment) {
		super();
		this.tea_id = tea_id;
		this.tea_name = tea_name;
		this.tea_sex = tea_sex;
		this.updatedTeacherLesson = updatedTeacherLesson;
		this.tea_birth = tea_birth;
		this.tea_comment = tea_comment;
	}
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getTea_sex() {
		return tea_sex;
	}
	public void setTea_sex(String tea_sex) {
		this.tea_sex = tea_sex;
	}
	public String getUpdatedTeacherLesson() {
		return updatedTeacherLesson;
	}
	public void setUpdatedTeacherLesson(String updatedTeacherLesson) {
		this.updatedTeacherLesson = updatedTeacherLesson;
	}
	public String getTea_birth() {
		return tea_birth;
	}
	public void setTea_birth(String tea_birth) {
		this.tea_birth = tea_birth;
	}
	public String getTea_comment() {
		return tea_comment;
	}
	public void setTea_comment(String tea_comment) {
		this.tea_comment = tea_comment;
	}
	@Override
	public String toString() {
		return "UpdateTeacherForm [tea_id=" + tea_id + ", tea_name=" + tea_name + ", tea_sex=" + tea_sex
				+ ", updatedTeacherLesson=" + updatedTeacherLesson + ", tea_birth=" + tea_birth + ", tea_comment="
				+ tea_comment + "]";
	}
	
	
}
