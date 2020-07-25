package com.koku.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;



@Component
@Validated
public class AddStudentForm {
	
	@NotBlank(message = "student name can not be blank")
	private String stuName;
	@NotNull(message = "student sex must be seleted")
	private String stuSex;
	@NotBlank(message = "student birth must be input")
	private String stuBirth;
	@NotBlank(message = "please select a teacher for this student")
	private String stuTeacher;
	
	public AddStudentForm() {
		super();
	}
	
	public AddStudentForm(String stuName,String stuSex,String stuBirth,String stuTeacher) {
		super();
		this.stuName=stuName;
		this.stuSex=stuSex;
		this.stuBirth=stuBirth;
		this.stuTeacher=stuTeacher;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuBirth() {
		return stuBirth;
	}

	public void setStuBirth(String stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuTeacher() {
		return stuTeacher;
	}

	public void setStuTeacher(String stuTeacher) {
		this.stuTeacher = stuTeacher;
	}

	@Override
	public String toString() {
		return "AddStudentForm [stuName=" + stuName + ", stuSex=" + stuSex + ", stuBirth=" + stuBirth + ", stuTeacher="
				+ stuTeacher + "]";
	}
	
}
