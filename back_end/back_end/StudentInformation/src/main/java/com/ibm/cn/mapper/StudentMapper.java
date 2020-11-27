package com.ibm.cn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.cn.model.Student;
@Mapper
public interface StudentMapper {
	
	//添加User
	public int addUser(Student book);
	
	//通过id查询User信息，返回string值
	public Student getUserById(String id);
	
	//通过id查询User信息，返回一个student对象
	public Student getUserById(Student student);
	
	//查询全部User信息
	public List<Student> getAllUsers();
	
	//分页
	public List<Student> queryUsersBySql(Map<String, Object> data);
	
	//通过名字查询User信息		
	public Student getUserByName(String name);
	
	//用户注册功能
	public String register(@RequestBody String id , String name,String tel , String password);
	
	//用户登入功能
	public String login(@RequestBody String id, String password);
	
	//统计功能
	public String count(@RequestBody String stuClass );
	
	//统计Student功能
	public String countstudent(String stuClass);
	
	//修改用户密码
	public int updateUser(Student student);
	
	//通过Id修改User信息
	public int updateUserTableByID(Student student);
	
	//通过id修改User信息
	public int deleteUserById(String id);
	
	//导出到excel表
	@Select("select * from usertable")
	public List<Student> teacherinfor();

}