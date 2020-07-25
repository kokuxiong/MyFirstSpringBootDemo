package com.koku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koku.dao.StudentDao;
import com.koku.pojo.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getAllofStudent(){
		List<Student> students = studentDao.findAllStudent();
		//format all of the student's birth to yyyy-MM-dd
		students.forEach((stu)->{stu.setStu_birth(stu.getStu_birth().substring(0, 10));});
		return students;
	}
	public List<Student> findStudentsByTeacherId(int tid){
		return studentDao.findStudentsByTeacherId(tid);
	}
	public Student findStudentById(int id) {
		Student stu =studentDao.findStudentById(id);
		//format date as yyyy-MM-dd
		stu.setStu_birth(stu.getStu_birth().substring(0, 10));
		return stu;
	}
	public int addNewStudent(Student stu) {
		return studentDao.addNewStudent(stu);
	};
	public int updateStudent(Student stu) {
		return studentDao.updateStudent(stu);
	};
	public int deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	};
}
