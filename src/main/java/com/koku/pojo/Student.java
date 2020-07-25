package com.koku.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Student {
	
	private int stu_id;
	private String stu_name;
	private String stu_sex;
	private String stu_birth;
	private int teacher_id;
	
	public Student() {
		super();
	}
	public Student(int stu_id, String stu_name, String stu_sex, String stu_birth, int teacher_id) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_birth = stu_birth;
		this.teacher_id = teacher_id;
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
	public void setTeacher_id(int id) {
		this.teacher_id = id;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex + ", stu_birth="
				+ stu_birth + ", teacher_id=" + teacher_id + "]";
	}
	
	
}
