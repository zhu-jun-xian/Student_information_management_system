package com.ibm.cn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.cn.mapper.StudentMapper;
import com.ibm.cn.model.Student;

@Service
public class StudentService {
	 @Autowired
	 StudentMapper studentMapper;
	//添加User
	 public int addUser(Student b) {
	  return studentMapper.addUser(b);
	 }
	//通过id查询User信息
	 public Student getUserById(String id) {
	  return studentMapper.getUserById(id);
	 }
	 //通过id查询User信息
	 public Student getUserById(Student student) {
		return studentMapper.getUserById(student);
	 }
	 //通过name查询User信息
	 public Student getUserByName(String name) {
		  return studentMapper.getUserByName(name);
	}
	//查询全部User信息
	 public List<Student> getAllUsers() {
	  return studentMapper.getAllUsers();
	 }
	//分页
	 public List<Student> queryUsersBySql(int currPage, int pageSize) {
	  Map<String, Object> data = new HashMap();
	  data.put("currIndex", (currPage - 1) * pageSize);
	  data.put("pageSize", pageSize);
	  return studentMapper.queryUsersBySql(data);
	 }
	//用户注册功能
	 public String register(@RequestBody String id,String name ,String tel, String password) {
		return studentMapper.register(id,name,tel,password);
		 
	 }
	 //用户登入功能
	public String login(@RequestBody String id,String password) {
		return studentMapper.login(id,password);
	}
	//统计
	public String count(@RequestBody String stuClass ) {
		return studentMapper.count(stuClass);
	}
	
	public String countstudent(String stuClass) {
		return studentMapper.count(stuClass);
	}
     //修改密码
	 public int updateUser(Student student) {
		  return studentMapper.updateUser(student);
	}
	 //通过id修改学生信息
	 public int updateUserTableByID(Student student) {
		   return studentMapper.updateUserTableByID(student);
		  }
	 //通过id删除学生信息
	 public int deleteUserById(String id) {
		   return studentMapper.deleteUserById(id);
		  }
	 //导出到excel表
	 public List<Student> teacherinfor(){
		    return studentMapper.teacherinfor();
	 }

}