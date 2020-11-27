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

	//添加Messages
	public int addMessages(Messages messages) {
		
		return messagesMapper.addMessages(messages);
	}

	//查询全部Messages
	public List<Messages> getAllMessages() {
		
		return messagesMapper.getAllMessages();
	}
	
	//根据stuID更新Messgaes
	public Messages getMessagesById(Messages stuID) {
		return messagesMapper.getMessagesById(stuID);
	}
	
	//根据stuName更新Messgaes
	public Messages getMessagesByName(Messages stuName) {
		return messagesMapper.getMessagesByName(stuName);
	}
	
	//根据stuID删除Messgaes
	public int deleteMessagesById(String stuID) {
		return messagesMapper.deleteMessagesById(stuID);
	}
	
	//根据stuName删除Messgaes
	public int deleteMessagesByName(String stuName) {
		return messagesMapper.deleteMessagesByName(stuName);
	}
	
	//根据stuName更新Messgaes
	public int updateMessagesByName(Messages messages) {
		
		return messagesMapper.updateMessagesByName(messages);
	}
	
	//根据stuID更新Messgaes
	public int updateMessagesById(Messages messages) {
		
		return messagesMapper.updateMessagesById(messages);
	}
	
	//根据stuID查询Messages
	public Messages getByStuID(String stuID) {
		return messagesMapper.getByStuID(stuID);
	}
	
	//根据stuName查询Messgaes
	public List<Messages> SelectByStuName(Messages stuName) {		
		return messagesMapper.SelectByStuName(stuName);
	}
	
	//根据stuClass查询Messgaes
	public List<Messages> SelectByStuClass(Messages stuClass) {		
		return messagesMapper.SelectByStuClass(stuClass);
	}
	
	//根据stuDep查询Messgaes
	public List<Messages> SelectByStuDep(Messages stuDep) {		
		return messagesMapper.SelectByStuDep(stuDep);
	}
	
	//根据stuSex查询Messgaes
	public List<Messages> SelectByStuSex(String stuSex) {		
		return messagesMapper.SelectByStuSex(stuSex);
	}

	//根据stuSex统计数据
	public List<Sex> getCountBySex(){
		return messagesMapper.getCountBySex();
	}

	//根据输入的任意的值查询Messgaes,支持模糊查询
	public List<Messages> SelectByStuAll(Messages stu) {  
		  return messagesMapper.SelectByStuAll(stu);
	}
	
	//根据输入的任意的值查询Messgaes,支持模糊查询
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
