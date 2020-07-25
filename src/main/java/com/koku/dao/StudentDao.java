package com.koku.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koku.pojo.Student;

@Repository
public interface StudentDao {
	List<Student> findAllStudent();
	List<Student> findStudentsByTeacherId(int tid);
	Student findStudentById(int id);
	int addNewStudent(Student stu);
	int updateStudent(Student stu);
	int deleteStudent(int id);
}
