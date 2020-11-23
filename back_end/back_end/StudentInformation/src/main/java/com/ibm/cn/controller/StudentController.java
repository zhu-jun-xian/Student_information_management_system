package com.ibm.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cn.model.Student;
import com.ibm.cn.service.StudentService;

@RestController
public class StudentController {
 @Autowired
 StudentService studentService;


 @CrossOrigin
 @PostMapping("/register")
 public String register(@RequestBody Student b){
	System.out.println("ssss:"+b.getName());
	Student student = studentService.getUserById(b.getId());
	if(student == null) {
		studentService.addUser(b);
		
		System.out.println("注册成功");
		return "success" ;
	}
	else {
	  System.out.println("用户名重复，请重新输入");
	  return "fault";
	}
}
 @CrossOrigin
 @PostMapping("/login")
 public String login(@RequestBody Student c) {
	 System.out.println("ID99:"+c.getPassword());
	 Student student = studentService.getUserById(c.getId());
	 System.out.println("ID:"+c.getId());
	 System.out.println("Pass:"+c.getPassword());
	 if(student == null) {
			System.out.println("用户名不存在");
			return "fault" ;
		}
		else {
			
			if((c.getPassword()).equals(student.getPassword())) {
				System.out.println("登入成功");
			return "success";
			}
			else {
				System.out.println("密码错误");
			 return "fault";
			}
		}
 }
 
 	@CrossOrigin
	@GetMapping("/getUserById")
	public Student getUserById(@RequestBody String id) {
		Student student = studentService.getUserById(id);
		return student;
	}
 	
 	
 	 @PostMapping("/updateUser")
 	 public String updateUser(@RequestBody Student s) {
 	//  System.out.println("pwd"+f.getPassword()+"id"+f.getId());
 	    
 	    Student student = studentService.getUserById(s.getId());
 	   
 	   if(student == null)
 	   {
 	    System.out.println("用户名不存在"); 
 	   return "fault" ;
 	   } 
 	   else if(!(student.getPassword().equals(s.getOldpassword()))){
 	    System.out.println("旧密码不正确"); 
 	   return "旧密码不正确" ;
 	   }
 	   else {
 	  
 	    student.setPassword(s.getPassword());
 	    studentService.updateUser(student);
 	    return "新密码修改成功";
 	   }
 	 }
}
