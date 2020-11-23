package com.ibm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cn.model.Messages;
import com.ibm.cn.service.MessagesService;

//允许前后端
@CrossOrigin
@RestController
public class MessagesController {
	@Autowired
	MessagesService messagesService;
	@GetMapping("/findAll")
	public List<Messages> findAll() {
		List<Messages> list =  messagesService.getAllMessages();
		System.out.println("sdsdsd");
		return list;
	}
	
	@PostMapping("/addMessages")
	public String add(@RequestBody Messages messages) {
		messagesService.addMessages(messages);
		return "ok";
	}
	
	@GetMapping("/getMessagesById")
	public Messages getMessagesById(@RequestBody String stuID) {
		Messages messages = messagesService.getMessagesById(stuID);
		return messages;
	}
	
	@GetMapping("/getMessagesByName")
	public Messages getMessagesByName(@RequestBody String stuName) {
		System.out.println(stuName);
		Messages messages = messagesService.getMessagesByName(stuName);
		return messages;
	}
	
	@GetMapping("/deleteMessagesById")
	public String deleteMessagesById(@RequestBody String stuID) {
		messagesService.deleteMessagesById(stuID);
		return "ok";
	}
	
	@GetMapping("/deleteMessagesByName")
	public String deleteMessagesByName(@RequestBody String stuName) {
		messagesService.deleteMessagesByName(stuName);
		return "ok";
	}
	
	@PostMapping("/updateMessagesByName")
	public String updateMessagesByName(@RequestBody Messages messages) {
		messagesService.updateMessagesByName(messages);
		return "ok";
	}
	
	@PostMapping("/updateMessagesById")
	public String updateMessagesById(@RequestBody Messages messages) {
		messagesService.updateMessagesById(messages);
		return "ok";
	}
	
	
	
	@GetMapping("/getByStuID")
	public Messages getByStuID(@RequestBody String stuID) {
		System.out.println(stuID);
		Messages messages = messagesService.getByStuID(stuID);
		return messages;
	}
	
	@GetMapping("/SelectByStuName")
	public List<Messages> SelectByStuName(@RequestBody String stuName) {
		List<Messages> list =  messagesService.SelectByStuName(stuName);
		return list;
	}
	
	@GetMapping("/SelectByStuClass")
	public List<Messages> SelectByStuClass(@RequestBody String stuClass) {
		List<Messages> list =  messagesService.SelectByStuClass(stuClass);
		int count = list.size();
		return list;
	}
	
	@GetMapping("/SelectByStuDep")
	public List<Messages> SelectByStuDep(@RequestBody String stuDep) {
		List<Messages> list =  messagesService.SelectByStuDep(stuDep);
		return list;
	}
	
	@GetMapping("/SelectByStuSex")
	public List<Messages> SelectByStuSex(@RequestBody String stuSex) {
		List<Messages> list =  messagesService.SelectByStuSex(stuSex);
		
		int count=list.size();
		System.out.println(count);
		return list;
	}
	
	//统计
	@GetMapping("/CountByStuSex")
	public int CountByStuSex(@RequestBody String stuSex) {
		List<Messages> list =  messagesService.CountByStuSex(stuSex);
		int count=list.size();
		return count;
	}
	@GetMapping("/CountByStuClass")
	public int CountByStuClass(@RequestBody String stuClass) {
		List<Messages> list =  messagesService.CountByStuClass(stuClass);
		int count = list.size();
		return count;
	}
	@GetMapping("/CountByStuDep")
	public int CountByStuDep(@RequestBody String stuDep) {
		List<Messages> list =  messagesService.CountByStuDep(stuDep);
		int count = list.size();
		return count;
	}
}
