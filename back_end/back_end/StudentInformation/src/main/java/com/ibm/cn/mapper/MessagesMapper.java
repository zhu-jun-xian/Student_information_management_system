package com.ibm.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.cn.model.Messages;

@Mapper
public interface MessagesMapper {
	
	public int addMessages(Messages messages);
	
	public int deleteMessagesById(String stuID);

	public int deleteMessagesByName(String stuName);
	
	public int updateMessagesByName(Messages messages);
	
	public int updateMessagesById(Messages messages);
	
	public Messages getMessagesById(String stuID);
	
	public Messages getMessagesByName(String stuName);
	
	public List<Messages> getAllMessages();
	
	public Messages getByStuID(String stuID);

	public List<Messages> SelectByStuName(String stuName);

	public List<Messages> SelectByStuClass(String stuClass);

	public List<Messages> SelectByStuDep(String stuDep);
	
	public List<Messages> SelectByStuSex(String stuSex);
	

	//统计
	public List<Messages> CountByStuSex(String stuSex);
	public List<Messages> CountByStuClass(String stuClass);
	public List<Messages> CountByStuDep(String stuDep);
//	
}
