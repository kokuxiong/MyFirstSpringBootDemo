package com.koku.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class AddTeacherForm {
	
	@NotBlank(message = "teacher name can not be blank")
	private String teaName;
	@NotNull(message = "teaher sex must be seleted")
	private String teaSex;
	@NotBlank(message = "please select a lesson")
	private String teaLesson;
	@NotBlank(message = "teacher birth must be input")
	private String teaBirth;
	@NotBlank(message = "please input something about the teacher")
	private String teaComment;
	
	public AddTeacherForm() {
		super();
	}
	public AddTeacherForm(String teaName, String teaSex, String teaLesson, String teaBirth, String teaComment) {
		super();
		this.teaName = teaName;
		this.teaSex = teaSex;
		this.teaLesson = teaLesson;
		this.teaBirth = teaBirth;
		this.teaComment = teaComment;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaSex() {
		return teaSex;
	}
	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}
	public String getTeaLesson() {
		return teaLesson;
	}
	public void setTeaLesson(String teaLesson) {
		this.teaLesson = teaLesson;
	}
	public String getTeaBirth() {
		return teaBirth;
	}
	public void setTeaBirth(String teaBirth) {
		this.teaBirth = teaBirth;
	}
	public String getTeaComment() {
		return teaComment;
	}
	public void setTeaComment(String teaComment) {
		this.teaComment = teaComment;
	}
	@Override
	public String toString() {
		return "AddTeacherForm [teaName=" + teaName + ", teaSex=" + teaSex + ", teaLesson=" + teaLesson + ", teaBirth="
				+ teaBirth + ", teaComment=" + teaComment + "]";
	}
	
	
}
