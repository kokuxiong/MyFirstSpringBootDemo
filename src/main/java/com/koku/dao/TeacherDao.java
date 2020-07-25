package com.koku.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koku.pojo.Teacher;

@Repository
public interface TeacherDao {
	List<Teacher> findAllTeacher();
	Teacher findTeacherById(int id);
	int addTeacher(Teacher tea);
	int updateTeacher(Teacher ter);
	int deleteTeacher(int id);
}
