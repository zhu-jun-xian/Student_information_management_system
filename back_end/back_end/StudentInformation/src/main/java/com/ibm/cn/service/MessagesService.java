package com.ibm.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cn.mapper.MessagesMapper;
import com.ibm.cn.model.Messages;

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
	
	public Messages getMessagesById(String stuID) {
		return messagesMapper.getMessagesById(stuID);
	}
	
	public Messages getMessagesByName(String stuName) {
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
	
	public List<Messages> SelectByStuName(String stuName) {		
		return messagesMapper.SelectByStuName(stuName);
	}
	
	public List<Messages> SelectByStuClass(String stuClass) {		
		return messagesMapper.SelectByStuClass(stuClass);
	}
	
	public List<Messages> SelectByStuDep(String stuDep) {		
		return messagesMapper.SelectByStuDep(stuDep);
	}
	
	public List<Messages> SelectByStuSex(String stuSex) {		
		return messagesMapper.SelectByStuSex(stuSex);
	}

	//统计
	public List<Messages> CountByStuSex(String stuSex) {
		return messagesMapper.CountByStuSex(stuSex);
	}
	public List<Messages> CountByStuClass(String stuClass) {
		return messagesMapper.CountByStuClass(stuClass);
	}
	public List<Messages> CountByStuDep(String stuDep) {
		return messagesMapper.CountByStuDep(stuDep);
	}
	
}
