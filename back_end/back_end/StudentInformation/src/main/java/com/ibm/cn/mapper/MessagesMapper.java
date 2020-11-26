package com.ibm.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ibm.cn.model.Messages;
import com.ibm.cn.model.Sex;

@Mapper
public interface MessagesMapper {
	
	public int addMessages(Messages messages);
	
	public int deleteMessagesById(String stuID);

	public int deleteMessagesByName(String stuName);
	
	public int updateMessagesByName(Messages messages);
	
	public int updateMessagesById(Messages messages);
	
	public Messages getMessagesById(Messages stuID);
	
	public Messages getMessagesByName(Messages stuName);
	
	public List<Messages> getAllMessages();
	
	public Messages getByStuID(String stuID);

	public List<Messages> SelectByStuName(Messages stuName);

	public List<Messages> SelectByStuClass(Messages stuClass);

	public List<Messages> SelectByStuDep(Messages stuDep);
	
	public List<Messages> SelectByStuSex(String stuSex);
	
	public List<Messages> SelectByStuAll(Messages stu);
	
	public List<Messages> SelectMessagesByStuAll(Messages messages);
	
	public List<Sex> getCountBySex();
	
	
	//汇总统计
	public List<Messages> CountByStuSex();
	 public List<Messages> CountByStuClass();
	 public List<Messages> CountByStuDep();
	 
	 
	 //导出Excel
		@Select("select * from studentinformationtable")
		public List<Messages> teacherinfor();

}
