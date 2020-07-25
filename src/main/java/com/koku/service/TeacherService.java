package com.koku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koku.controller.TeacherController;
import com.koku.dao.StudentDao;
import com.koku.dao.TeacherDao;
import com.koku.pojo.Teacher;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherController teaCtrl;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private StudentService stuService;
	
	public List<Teacher> findAllTeachers(){
		List<Teacher> teachers = teacherDao.findAllTeacher();
		//format all of the teacher's birth to yyyy-MM-dd 
		teachers.forEach((tea)->{tea.setTea_birth(tea.getTea_birth().substring(0, 10));});
		return teachers;
	}
	public Teacher findTeacherById(int id) {
		Teacher tea = teacherDao.findTeacherById(id);
		//format date to yyyy-MM-dd
		tea.setTea_birth(tea.getTea_birth().substring(0, 10));
		return tea;
	}
	public int addTeacher(Teacher tea) {
		return teacherDao.addTeacher(tea);
	}
	public int updateTeacher(Teacher tea) {
		return teacherDao.updateTeacher(tea);
	}
	public int deleteTeacherById(int id) {
		//
		if(stuService.findStudentsByTeacherId(id).size() > 0) {
			//can not be deleted
			teaCtrl.setDeleteErrorMsg("Can not delete this teacher,because the teacher has students! Please delete student first!");
			return 0;
		}else {
			return teacherDao.deleteTeacher(id);
		}
		
	}
}
