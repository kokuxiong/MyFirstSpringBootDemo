package com.koku.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Teacher {
	private int tea_id;
	private String tea_name;
	private String tea_sex;
	private String tea_lesson;
	private String tea_birth;
	private String tea_comment;
	
	public Teacher() {
		super();
	}
	
	public Teacher(int tea_id,String tea_name,String tea_sex,String tea_lesson,String tea_birth,String tea_comment) {
		this.tea_id=tea_id;
		this.tea_name=tea_name;
		this.tea_sex=tea_sex;
		this.tea_lesson=tea_lesson;
		this.tea_birth=tea_birth;
		this.tea_comment=tea_comment;
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
		return "Teacher [tea_id=" + tea_id + ", tea_name=" + tea_name + ", tea_sex=" + tea_sex + ", tea_lesson="
				+ tea_lesson + ", tea_birth=" + tea_birth + ", tea_comment=" + tea_comment + "]";
	}
	
	
}
