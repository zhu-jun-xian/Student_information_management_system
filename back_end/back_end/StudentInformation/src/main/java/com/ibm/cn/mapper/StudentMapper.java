package com.ibm.cn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.cn.model.Student;
@Mapper
public interface StudentMapper {
	public int addUser(Student book);
	
	public Student getUserById(String id);
	
	public Student getUserById(Student student);
	
	public List<Student> getAllUsers();
	
	public List<Student> queryUsersBySql(Map<String, Object> data);
	
	public Student getUserByName(String name);
	
	public String register(@RequestBody String id , String name,String tel , String password);
	
	public String login(@RequestBody String id, String password);
	
	public String count(@RequestBody String stuClass );
	
	public String countstudent(String stuClass);
	
	public int updateUser(Student student);
	
	public int updateUserTableByID(Student student);
	
	public int deleteUserById(String id);
	
	@Select("select * from usertable")
	public List<Student> teacherinfor();

}