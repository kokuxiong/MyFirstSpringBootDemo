package com.koku.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koku.form.AddTeacherForm;
import com.koku.form.UpdateTeacherForm;
import com.koku.pojo.Teacher;
import com.koku.pojo.TeacherAndLesson;
import com.koku.service.TeacherService;
import com.koku.util.GetTeacherAndLesson;
import com.koku.util.Lessons;

@Controller
public class TeacherController {
	
	private String deleteErrorMsg = "";
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private GetTeacherAndLesson getTeaAndLesson;
	
	@RequestMapping("/koku/teacherList")
	public String showTeacherList(Model model) {
		
		List<Teacher> teachers = teacherService.findAllTeachers();
		List<TeacherAndLesson> tals = getTeaAndLesson.getTeaAndLessons(teachers);
		model.addAttribute("teachers", tals);
		model.addAttribute("deleteErrorMsg", this.getDeleteErrorMsg());
		return "teacherList";
	}
	
	@RequestMapping("/koku/linkToAddTeacher")
	public String linkToAddTeacher(Model model) {
		//
		this.setDeleteErrorMsg("");
		AddTeacherForm addTeacherForm = new AddTeacherForm();
		Map<Integer,String> lessons = Lessons.getLessons();
		model.addAttribute("addTeacherForm", addTeacherForm);
		model.addAttribute("lessons", lessons);
		return "addTeacher";
	}
	
	@RequestMapping("/koku/addTeacher")
	public String addTeacher(@Validated @ModelAttribute AddTeacherForm addTeacherForm,BindingResult bindRs,Model model) {
		
		if(bindRs.hasErrors()) {
			Map<Integer,String> lessons = Lessons.getLessons();
			model.addAttribute("lessons", lessons);
			return "addTeacher";
			
		}
		Teacher tea = new Teacher();
		tea.setTea_name(addTeacherForm.getTeaName());
		tea.setTea_sex(addTeacherForm.getTeaSex());
		tea.setTea_lesson(addTeacherForm.getTeaLesson());
		tea.setTea_birth(addTeacherForm.getTeaBirth());
		tea.setTea_comment(addTeacherForm.getTeaComment());
		teacherService.addTeacher(tea);
		return "redirect:/koku/teacherList";
	}
	
	@RequestMapping("/koku/linkToUpdateTeacher/{id}")
	public String linkToUpdateTeacher(@PathVariable("id") int id,Model model) {
		//
		this.setDeleteErrorMsg("");
		
		Map<Integer,String> lessons = Lessons.getLessons();
		Teacher tea = teacherService.findTeacherById(id);
		UpdateTeacherForm updateTeaForm = this.getUpdateTeacherFormByTeacher(tea);
		model.addAttribute("updateTeacherForm", updateTeaForm);
		model.addAttribute("lessons", lessons);
		return "updateTeacher";
	}
	
	@RequestMapping("/koku/updateTeacher")
	public String updateTeacher(@Validated @ModelAttribute UpdateTeacherForm updateTeacherForm,BindingResult bindRs,Model model) {
		
		if(bindRs.hasErrors()) {
			Map<Integer,String> lessons = Lessons.getLessons();
			model.addAttribute("lessons", lessons);
			return "updateTeacher";
			
		}
		Teacher tea = new Teacher();
		tea.setTea_id(Integer.valueOf(updateTeacherForm.getTea_id()));
		tea.setTea_name(updateTeacherForm.getTea_name());
		tea.setTea_sex(updateTeacherForm.getTea_sex());
		tea.setTea_lesson(updateTeacherForm.getUpdatedTeacherLesson());
		tea.setTea_birth(updateTeacherForm.getTea_birth());
		tea.setTea_comment(updateTeacherForm.getTea_comment());

		teacherService.updateTeacher(tea);
		
		return "redirect:/koku/teacherList";
	}
	@RequestMapping("/koku/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable("id") int id) {
		//
		this.setDeleteErrorMsg("");
		
		teacherService.deleteTeacherById(id);
		return "redirect:/koku/teacherList";
	}

	public String getDeleteErrorMsg() {
		return deleteErrorMsg;
	}

	public void setDeleteErrorMsg(String deleteErrorMsg) {
		this.deleteErrorMsg = deleteErrorMsg;
	}
	
	private UpdateTeacherForm getUpdateTeacherFormByTeacher(Teacher tea) {
		
		//
		UpdateTeacherForm updateTeaForm = new UpdateTeacherForm();
		if(tea != null) {
			updateTeaForm.setTea_id(String.valueOf(tea.getTea_id()));
			updateTeaForm.setTea_name(tea.getTea_name());
			updateTeaForm.setTea_sex(tea.getTea_sex());
			updateTeaForm.setUpdatedTeacherLesson(tea.getTea_lesson());
			updateTeaForm.setTea_birth(tea.getTea_birth());
			updateTeaForm.setTea_comment(tea.getTea_comment());
		}

		return updateTeaForm;
	}
	
}
