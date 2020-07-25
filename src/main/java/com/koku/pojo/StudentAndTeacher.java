package com.koku.pojo;

import org.springframework.stereotype.Component;

@Component
public class StudentAndTeacher {

	//student
	private int stu_id;
	private String stu_name;
	private String stu_sex;
	private String stu_birth;
	private int teacher_id;
	
	//teacher
	private int tea_id;
	private String tea_name;
	private String tea_sex;
	private String tea_lesson;
	private String tea_birth;
	private String tea_comment;
	
	public StudentAndTeacher() {
		super();
	}

	public StudentAndTeacher(int stu_id, String stu_name, String stu_sex, String stu_birth, int teacher_id, int tea_id,
			String tea_name, String tea_sex, String tea_lesson, String tea_birth, String tea_comment) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_birth = stu_birth;
		this.teacher_id = teacher_id;
		this.tea_id = tea_id;
		this.tea_name = tea_name;
		this.tea_sex = tea_sex;
		this.tea_lesson = tea_lesson;
		this.tea_birth = tea_birth;
		this.tea_comment = tea_comment;
	}
	
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
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
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
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
	public String getTea_lesson() {
		return tea_lesson;
	}
	public void setTea_lesson(String tea_lesson) {
		this.tea_lesson = tea_lesson;
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
		return "StudentAndTeacher [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex
				+ ", stu_birth=" + stu_birth + ", teacher_id=" + teacher_id + ", tea_id=" + tea_id + ", tea_name="
				+ tea_name + ", tea_sex=" + tea_sex + ", tea_lesson=" + tea_lesson + ", tea_birth=" + tea_birth
				+ ", tea_comment=" + tea_comment + "]";
	}
	
	
}
