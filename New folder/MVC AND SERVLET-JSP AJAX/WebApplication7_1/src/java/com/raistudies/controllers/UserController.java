package com.raistudies.controllers;

import com.vimal.dao.StudentDaoImpl;
import com.vimal.model.Student;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
        @RequestMapping(value={"/"})
	public String showForm1(){
		return "index";
	}
        
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
	public String showForm(){
		return "AddUser";
	}
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	public @ResponseBody String addUser(@ModelAttribute(value="student") Student student, BindingResult result ){
            
		String name = student.getName();
		String email = student.getEmail();
		String phone = student.getContact();
		Integer marks = student.getMarks();
		Student student1 = new Student(name,email,phone,marks);
		if(new StudentDaoImpl().saveStudent(student1)){
			return "Save Successfully";
		}
		else
		{
			return "Not save";
		}
	}

}
