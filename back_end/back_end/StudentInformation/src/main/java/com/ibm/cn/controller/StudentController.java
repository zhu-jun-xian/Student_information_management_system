package com.ibm.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cn.model.Student;
import com.ibm.cn.service.StudentService;

@RestController
public class StudentController {
 @Autowired
 StudentService studentService;

//允许前后端
 @CrossOrigin
 //用户注册功能
 @PostMapping("/register")
 public String register(@RequestBody Student b){
	System.out.println("注册名:"+b.getName());
	Student student = studentService.getUserById(b.getId());
	if(student == null) {
		studentService.addUser(b);
		
		System.out.println("注册成功");
		System.out.println(b);
		return "success" ;
	}
	else {
	  System.out.println("用户名重复，请重新输入");
	  return "fault";
	}
}
 //允许前后端
 @CrossOrigin
 //用户登入功能
 @PostMapping("/login")
 public String login(@RequestBody Student c) {
	 System.out.println("尝试登录用户名:"+c.getName());
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
				System.out.println(student);
			return "success";
			}
			else {
				System.out.println("登录密码错误");
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
 	//通过id查询User信息
 	@CrossOrigin
	@PostMapping("/getUserById1")
	public Student getUserById(@RequestBody Student stu) {
		Student student = studentService.getUserById(stu.getId());
		return student;
	}
 	//修改密码功能
 	@CrossOrigin
 	 @PostMapping("/updateUserPassword")
 	 public String updateUser(@RequestBody Student s) {
 	    
 	    Student student = studentService.getUserById(s.getId());
 	   
 	   if(student == null){
 	    System.out.println("用户名不存在"); 
 	    return "fault" ;
 	   } 
// 	   else if(!(student.getPassword().equals(s.getOldpassword()))){
// 	    System.out.println("旧密码不正确"); 
// 	   return "旧密码不正确" ;
// 	   }
 	   else {
 	    student.setPassword(s.getPassword());
 	    studentService.updateUser(student);
 	    System.out.println(student);
 	    return "新密码修改成功";
 	   }
 	 }
 	//通过id修改User信息
 	@PostMapping("/updateUserTableByID")
 	 public String updateUserTableByID(@RequestBody Student student) {
 	  studentService.updateUserTableByID(student);
 	  return "success";
 	 }
 	
 	//通过id删除User信息
 	 @PostMapping("/deleteUser")
 	 public String deleteUser(@RequestBody Student s) {
 	  
 	  Student student = studentService.getUserById(s.getId());
 	  if (student ==null) {
 	  return "id不存在!";
 	  }
 	  else {
 	      studentService.deleteUserById(s.getId());
 	      return "success";
 	  }
 	 }
 	 
 	 //导出Excel表功能
 	@RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
 	public void downloadAllClassmate(HttpServletResponse response) throws IOException {
 	    System.out.println("下載信息表");
 	    HSSFWorkbook workbook = new HSSFWorkbook();
 	    HSSFSheet sheet = workbook.createSheet("信息表");

 	    List<Student> classmateList = studentService.teacherinfor();

 	    String fileName = "userinf"  + ".xls";//设置要导出的文件的名字
 	    //新增数据行，并且设置单元格数据

 	    int rowNum = 1;

 	    String[] headers = { "学号", "姓名", "电话", "登录密码"};
 	    //headers表示excel表中第一行的表头

 	    HSSFRow row = sheet.createRow(0);
 	    //在excel表中添加表头

 	    for(int i=0;i<headers.length;i++){
 	        HSSFCell cell = row.createCell(i);
 	        HSSFRichTextString text = new HSSFRichTextString(headers[i]);
 	        cell.setCellValue(text);
 	    }

 	    //在表中存放查询到的数据放入对应的列
 	    for (Student student : classmateList) {
 	        HSSFRow row1 = sheet.createRow(rowNum);
 	        row1.createCell(0).setCellValue(student.getId());
 	        row1.createCell(1).setCellValue(student.getName());
 	        row1.createCell(2).setCellValue(student.getTel());
 	        row1.createCell(3).setCellValue(student.getPassword());
 	        rowNum++;
 	    }

 	    response.setContentType("application/octet-stream");
 	    response.setHeader("Content-disposition", "attachment;filename=" + fileName);
 	    response.flushBuffer();
 	    workbook.write(response.getOutputStream());
 	}
 	 
}
