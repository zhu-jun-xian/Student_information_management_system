package com.ibm.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cn.mapper.MessagesMapper;
import com.ibm.cn.model.Messages;
import com.ibm.cn.model.Sex;

@Service
public class MessagesService {
	@Autowired
	MessagesMapper messagesMapper;

	public int addMessages(Messages messages) {
		
		return messagesMapper.addMessages(messages);
	}

	public List<Messages> getAllMessages() {
		
		return messagesMapper.getAllMessages();
	}
	
	public Messages getMessagesById(Messages stuID) {
		return messagesMapper.getMessagesById(stuID);
	}
	
	public Messages getMessagesByName(Messages stuName) {
		return messagesMapper.getMessagesByName(stuName);
	}
	
	public int deleteMessagesById(String stuID) {
		return messagesMapper.deleteMessagesById(stuID);
	}
	
	public int deleteMessagesByName(String stuName) {
		return messagesMapper.deleteMessagesByName(stuName);
	}
	
	public int updateMessagesByName(Messages messages) {
		
		return messagesMapper.updateMessagesByName(messages);
	}
	
	public int updateMessagesById(Messages messages) {
		
		return messagesMapper.updateMessagesById(messages);
	}
	
	
	
	public Messages getByStuID(String stuID) {
		return messagesMapper.getByStuID(stuID);
	}
	
	public List<Messages> SelectByStuName(Messages stuName) {		
		return messagesMapper.SelectByStuName(stuName);
	}
	
	public List<Messages> SelectByStuClass(Messages stuClass) {		
		return messagesMapper.SelectByStuClass(stuClass);
	}
	
	public List<Messages> SelectByStuDep(Messages stuDep) {		
		return messagesMapper.SelectByStuDep(stuDep);
	}
	
	public List<Messages> SelectByStuSex(String stuSex) {		
		return messagesMapper.SelectByStuSex(stuSex);
	}


	
	public List<Sex> getCountBySex(){
		return messagesMapper.getCountBySex();
	}

	public List<Messages> SelectByStuAll(Messages stu) {  
		  return messagesMapper.SelectByStuAll(stu);
	}
	
	public List<Messages> SelectMessagesByStuAll(Messages messages){
		
		return messagesMapper.SelectMessagesByStuAll(messages);
	}
	
	//汇总统计
	public List<Messages> CountByStuSex() {
		  return messagesMapper.CountByStuSex();
		 }
		 
		 public List<Messages> CountByStuClass() {
		  List<Messages> list=messagesMapper.CountByStuClass();
		//  return messagesMapper.CountByStuClass();
		  return list;
		 }
		 public List<Messages> CountByStuDep() {
		  return messagesMapper.CountByStuDep();
		 }
		 
		 
		 
	//导出
	public List<Messages> teacherinfor(){
	    return messagesMapper.teacherinfor();
	 }
}
