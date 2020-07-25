package com.koku.controller;



import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koku.form.AddStudentForm;
import com.koku.form.UpdateStudentForm;
import com.koku.pojo.Student;
import com.koku.pojo.StudentAndTeacher;
import com.koku.pojo.Teacher;
import com.koku.service.StudentService;
import com.koku.service.TeacherService;
import com.koku.util.GetStudentAndTeacher;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService	stuService;
	@Autowired
	private TeacherService teaService;
	@Autowired
	private GetStudentAndTeacher getStuAndTea;
	
	@RequestMapping("/koku/studentList")
	public String showStudentList(Model model) {
		
		//
		List<Student> stus = stuService.getAllofStudent();
		List<StudentAndTeacher> sats = getStuAndTea.getStuAndTeas(stus);
		
		model.addAttribute("students",sats);
		
		return "studentList";
	}
	
	@RequestMapping("/koku/linkToAddStudent")
	public String linkToAddStudent(Model model) {
		List<Teacher> teachers = teaService.findAllTeachers();
		AddStudentForm addStuForm = new AddStudentForm();
		model.addAttribute("addStuForm", addStuForm);
		model.addAttribute("teachers", teachers);
		teachers.forEach((t)->{System.out.println(t);});
		return "addStudent";
	}
	@RequestMapping("/koku/addStudent")
	public String addStudent(@Validated @ModelAttribute(name="addStuForm") AddStudentForm addStudentForm,BindingResult bindRs
			,Model model) {

		if(bindRs.hasErrors()) {
			//find all of the teacher,and add to the model
			List<Teacher> teachers = teaService.findAllTeachers();
			model.addAttribute("teachers", teachers);
			return "addStudent";
		}
		Student stu = new Student();

		stu.setStu_name(addStudentForm.getStuName());
		stu.setStu_sex(addStudentForm.getStuSex());
		stu.setStu_birth(addStudentForm.getStuBirth());
		stu.setTeacher_id(Integer.valueOf(addStudentForm.getStuTeacher()));
		
		stuService.addNewStudent(stu);
		return "redirect:/koku/studentList";
	}
	@RequestMapping("/koku/linkToUpdateStudent/{id}")
	public String linkToUpdateStudent(@PathVariable("id") int id,Model model) {
		
		Student stu = stuService.findStudentById(id);
		UpdateStudentForm updateStuForm = this.getUpdateStudentFormByStudent(stu);
		List<Teacher> teachers = teaService.findAllTeachers();
		
		model.addAttribute("updateStudentForm", updateStuForm);
		model.addAttribute("teachers", teachers);
		return "updateStudent";
	}
	@RequestMapping("/koku/updateStudent")
	public String updateStudent(@Validated @ModelAttribute UpdateStudentForm updateStudentForm,BindingResult bingRs,Model model) {
		
		//
		if(bingRs.hasErrors()) {
			
			List<Teacher> teachers = teaService.findAllTeachers();
			model.addAttribute("teachers", teachers);
			return "updateStudent";
		}
		
		Student stu=new Student();
		stu.setStu_id(Integer.valueOf(updateStudentForm.getStu_id()));
		stu.setStu_name(updateStudentForm.getStu_name());
		stu.setStu_sex(updateStudentForm.getStu_sex());
		stu.setStu_birth(updateStudentForm.getStu_birth());
		stu.setTeacher_id(Integer.valueOf(updateStudentForm.getTeacherId()));
		stuService.updateStudent(stu);
		return "redirect:/koku/studentList";
	}
	@RequestMapping("/koku/deleteStudent/{id}")
	public String linkToDeleteStudent(@PathVariable("id") int id) {
		stuService.deleteStudent(id);
		return "redirect:/koku/studentList";
	}
	
	/**
	 * get updateStudentForm from student instance
	 * @param stu
	 * @return
	 */
	private UpdateStudentForm getUpdateStudentFormByStudent(Student stu) {
		UpdateStudentForm updateStuForm = new UpdateStudentForm();
		if(stu != null) {
			updateStuForm.setStu_id(String.valueOf(stu.getStu_id()));
			updateStuForm.setStu_name(stu.getStu_name());
			updateStuForm.setStu_sex(stu.getStu_sex());
			updateStuForm.setStu_birth(stu.getStu_birth());
			updateStuForm.setTeacherId(String.valueOf(stu.getTeacher_id()));
		}
		//
		return updateStuForm;
	}

}
