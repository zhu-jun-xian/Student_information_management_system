package com.ibm.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ibm.cn.model.Messages;
import com.ibm.cn.model.Sex;

@Mapper
public interface MessagesMapper {
	
	//添加Messages
	public int addMessages(Messages messages);
	
	//根据stuID删除Messgaes
	public int deleteMessagesById(String stuID);
	
	//根据stuName删除Messgaes
	public int deleteMessagesByName(String stuName);
	
	//根据stuName更新Messgaes
	public int updateMessagesByName(Messages messages);
	
	//根据stuID更新Messgaes
	public int updateMessagesById(Messages messages);
	
	//根据stuID查询Messages
	public Messages getMessagesById(Messages stuID);
	
	//根据stuName查询Messgaes
	public Messages getMessagesByName(Messages stuName);
	
	//查询全部Messages
	public List<Messages> getAllMessages();
	
	//根据stuID查询Messgaes
	public Messages getByStuID(String stuID);
	
	//根据stuName查询Messgaes，支持模糊查询
	public List<Messages> SelectByStuName(Messages stuName);
	
	//根据stuClass查询Messgaes
	public List<Messages> SelectByStuClass(Messages stuClass);
	
	//根据stuDep查询Messgaes
	public List<Messages> SelectByStuDep(Messages stuDep);
	
	//根据stuSex查询Messgaes
	public List<Messages> SelectByStuSex(String stuSex);
	
	//根据输入的任意的值查询Messgaes,支持模糊查询
	public List<Messages> SelectByStuAll(Messages stu);
	
	//根据输入的任意的值查询Messgaes,支持模糊查询
	public List<Messages> SelectMessagesByStuAll(Messages messages);
	
	//根据stuSex统计数据
	public List<Sex> getCountBySex();
		
	//汇总统计
	public List<Messages> CountByStuSex();
	 public List<Messages> CountByStuClass();
	 public List<Messages> CountByStuDep();
	 
	 
	 //导出Excel
		@Select("select * from studentinformationtable")
		public List<Messages> teacherinfor();

}
