package com.koku.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koku.pojo.Student;
import com.koku.pojo.StudentAndTeacher;
import com.koku.pojo.Teacher;
import com.koku.service.TeacherService;

@Component
public class GetStudentAndTeacher {

	@Autowired
	private TeacherService teaService;
	
	public List<StudentAndTeacher> getStuAndTeas(List<Student> stus){
		
		List<StudentAndTeacher> stuAndTeas = new ArrayList<>();
		
		Teacher tea = null;
		for(Student stu : stus) {
			StudentAndTeacher sat = new StudentAndTeacher();
			if(tea != null && stu.getTeacher_id() == tea.getTea_id()) {
				
			}else {
				tea = teaService.findTeacherById(stu.getTeacher_id());
			}

			sat.setStu_id(stu.getStu_id());
			sat.setStu_name(stu.getStu_name());
			sat.setStu_sex(stu.getStu_sex());
			sat.setStu_birth(stu.getStu_birth());
			sat.setTeacher_id(stu.getTeacher_id());
			if(tea != null) {
				sat.setTea_id(tea.getTea_id());
				sat.setTea_name(tea.getTea_name());
				sat.setTea_sex(tea.getTea_sex());
				sat.setTea_lesson(tea.getTea_lesson());
				sat.setStu_birth(tea.getTea_birth());
				sat.setTea_comment(tea.getTea_comment());
			}
			stuAndTeas.add(sat);
		}
		
		return stuAndTeas;
	}
	
}
