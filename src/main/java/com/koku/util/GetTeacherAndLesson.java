package com.koku.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.koku.pojo.Teacher;
import com.koku.pojo.TeacherAndLesson;

@Component
public class GetTeacherAndLesson {

	public List<TeacherAndLesson> getTeaAndLessons(List<Teacher> teas){
		List<TeacherAndLesson> tals = new ArrayList<>();
		
		for(Teacher tea : teas) {
			TeacherAndLesson tal = new TeacherAndLesson();
			tal.setTea_id(tea.getTea_id());
			tal.setTea_name(tea.getTea_name());
			tal.setTea_sex(tea.getTea_sex());
			tal.setTea_lesson(tea.getTea_lesson());
			tal.setTea_birth(tea.getTea_birth());
			tal.setTea_comment(tea.getTea_comment());
			tal.setLessonKey(Integer.valueOf(tea.getTea_lesson()));
			tal.setLessonName(Lessons.getLessons().get(tal.getLessonKey()));
			tals.add(tal);
		}
		
		return tals;
	}
}
