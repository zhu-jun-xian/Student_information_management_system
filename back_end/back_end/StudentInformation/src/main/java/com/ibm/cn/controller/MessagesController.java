package com.ibm.cn.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.ibm.cn.model.Messages;
import com.ibm.cn.model.Sex;
import com.ibm.cn.service.MessagesService;

//允许前后端
@CrossOrigin
@RestController
public class MessagesController {
	
	@Autowired
	MessagesService messagesService;
	
	//查询全部Messages
	@GetMapping("/findAll")
	public List<Messages> findAll() {
		List<Messages> list =  messagesService.getAllMessages();
		return list;
	}
	
	//添加Messages
	@PostMapping("/addMessages")
	public String add(@RequestBody Messages messages) {
		messagesService.addMessages(messages);
		System.out.println("ok");
		return "ok";
	}
	
	//根据stuID查询Messages
	@PostMapping("/getMessagesById")
	public Messages getMessagesById(@RequestBody Messages stuID) {
		System.out.println("根據ID查詢-");
		System.out.println(stuID);
		Messages messages = messagesService.getMessagesById(stuID);
		System.out.println(messages);
		return messages;
	}
	
	//根据stuName查询Messgaes
	@PostMapping("/getMessagesByName")
	public Messages getMessagesByName(@RequestBody Messages stuName) {
		System.out.println(stuName);
		Messages messages = messagesService.getMessagesByName(stuName);
		return messages;
	}
	
	//根据stuID删除Messgaes
	@PostMapping("/deleteMessagesById")
	public String deleteMessagesById(@RequestBody Messages messages) {
		System.out.println("delete:" + messages);
		int i = messagesService.deleteMessagesById(messages.getStuID());
		System.out.println("返回：" +i);
		if(i==1) {
			return "ok";
		}
		else {
			return "false";
		}
	}
	
	//根据stuName删除Messgaes
	@GetMapping("/deleteMessagesByName")
	public String deleteMessagesByName(@RequestBody String stuName) {
		messagesService.deleteMessagesByName(stuName);
		return "ok";
	}
	
	//根据stuName更新Messgaes
	@PostMapping("/updateMessagesByName")
	public String updateMessagesByName(@RequestBody Messages messages) {
		messagesService.updateMessagesByName(messages);
		return "ok";
	}
	
	//根据stuID更新Messgaes
	@PostMapping("/updateMessagesById")
	public String updateMessagesById(@RequestBody Messages messages) {
		int i = messagesService.updateMessagesById(messages);
		System.out.println("返回：" +i);
		if(i==1) {
			return "ok";
		}
		else {
			return "false";
		}
	}
	
	//根据stuID查询Messgaes
	@GetMapping("/getByStuID")
	public Messages getByStuID(@RequestBody String stuID) {
		System.out.println(stuID);
		Messages messages = messagesService.getByStuID(stuID);
		return messages;
	}
		
	//根据stuName查询Messgaes，支持模糊查询
	@PostMapping("/SelectByStuName")
	public List<Messages> SelectByStuName(@RequestBody Messages stuName) {
		List<Messages> list =  messagesService.SelectByStuName(stuName);
		return list;
	}
	
	//根据stuClass查询Messgaes
	@PostMapping("/SelectByStuClass")
	public List<Messages> SelectByStuClass(@RequestBody Messages stuClass) {
		System.out.println(stuClass);
		List<Messages> list =  messagesService.SelectByStuClass(stuClass);
		System.out.println(list);
		return list;
	}
	
	//根据stuDep查询Messgaes
	@PostMapping("/SelectByStuDep")
	public List<Messages> SelectByStuDep(@RequestBody Messages stuDep) {
		System.out.println(stuDep);
		List<Messages> list =  messagesService.SelectByStuDep(stuDep);
		System.out.println(list);
		return list;
	}
	
	//根据stuSex查询Messgaes
	@GetMapping("/SelectByStuSex")
	public List<Messages> SelectByStuSex(@RequestBody String stuSex) {
		List<Messages> list =  messagesService.SelectByStuSex(stuSex);
		
		int count=list.size();
		System.out.println(count);
		return list;
	}
	
	//根据输入的任意的值查询Messgaes,支持模糊查询
	@PostMapping("/SelectByStuAll")
	public List<Messages> SelectByStuAll(@RequestBody Messages stu) {
		
		List<Messages> list =  messagesService.SelectByStuAll(stu);
		return list;
	}
	
	//根据输入的任意的值查询Messgaes,支持模糊查询
	@PostMapping("/SelectMessagesByStuAll")
	public List<Messages> SelectMessagesByStuAll(@RequestBody Messages messages) {
		System.out.println(messages);
		List<Messages> list =  messagesService.SelectMessagesByStuAll(messages);
		System.out.println(list);
		return list;
	}
	
	//	统计--------------------
	//根据stuSex统计数据
	@PostMapping("/getCountBySex")
	public List<Sex> getCountBySex() {
		List<Sex> list =  messagesService.getCountBySex();
		return list;
	}
	
	//汇总统计
	@GetMapping("/CountStuInfo")
	 public  List<Messages>  CountStuInfo() {
		System.out.println("匯總查詢");
	  //各个班级对应人数
	  List<Messages> listClassCount  = messagesService.CountByStuClass();
	  
	  //男女对应人数
	  List<Messages> listSexCount = messagesService.CountByStuDep();
	  
	  //各个院系对应人数
	  List<Messages> listDepCount = messagesService.CountByStuSex();
	  
	  //3个集合链接起来
	  List<Messages>  listAll =new ArrayList<Messages>();
	  
	  listAll.addAll(listClassCount);
	  listAll.addAll(listSexCount);
	  listAll.addAll(listDepCount);
	 
	  
	  

	  return listAll;
	 }
	
	@RequestMapping(value = "MessagesExcelDownloads", method = RequestMethod.GET)
 	public void downloadAllClassmate(HttpServletResponse response) throws IOException {
 	    
 	    HSSFWorkbook workbook = new HSSFWorkbook();
 	    HSSFSheet sheet = workbook.createSheet("信息表");

 	    List<Messages> classmateList = messagesService.teacherinfor();

 	    String fileName = "messagesinf"  + ".xls";//设置要导出的文件的名字
 	    //新增数据行，并且设置单元格数据

 	    int rowNum = 1;

 	    String[] headers = { "序号", "学号", "姓名", "出生日期","性别","电话","班级","学院","添加时间","图片路径"};
 	    //headers表示excel表中第一行的表头

 	    HSSFRow row = sheet.createRow(0);
 	    //在excel表中添加表头

 	    for(int i=0;i<headers.length;i++){
 	        HSSFCell cell = row.createCell(i);
 	        HSSFRichTextString text = new HSSFRichTextString(headers[i]);
 	        cell.setCellValue(text);
 	    }

 	    //在表中存放查询到的数据放入对应的列
 	    for (Messages messages : classmateList) {
 	        HSSFRow row1 = sheet.createRow(rowNum);
 	        row1.createCell(0).setCellValue(messages.getStuNum());
 	        row1.createCell(1).setCellValue(messages.getStuID());
 	        row1.createCell(2).setCellValue(messages.getStuName());
 	        row1.createCell(3).setCellValue(messages.getStuBirth());
 	        row1.createCell(4).setCellValue(messages.getStuSex());
	        row1.createCell(5).setCellValue(messages.getStuTel());
	        row1.createCell(6).setCellValue(messages.getStuClass());
	        row1.createCell(7).setCellValue(messages.getStuDep());
	        row1.createCell(8).setCellValue(messages.getStuAddTimed());
	        row1.createCell(9).setCellValue(messages.getStuImgUrl());
 	        rowNum++;
 	    }

 	    response.setContentType("application/octet-stream");
 	    response.setHeader("Content-disposition", "attachment;filename=" + fileName);
 	    response.flushBuffer();
 	    workbook.write(response.getOutputStream());
 	}
 	 
}



