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

 public int addUser(Student b) {
  return studentMapper.addUser(b);
 }

 public Student getUserById(String id) {
  return studentMapper.getUserById(id);
 }
 
 public Student getUserByName(String name) {
	  return studentMapper.getUserByName(name);
}

 public List<Student> getAllUsers() {
  return studentMapper.getAllUsers();
 }

 public List<Student> queryUsersBySql(int currPage, int pageSize) {
  Map<String, Object> data = new HashMap();
  data.put("currIndex", (currPage - 1) * pageSize);
  data.put("pageSize", pageSize);
  return studentMapper.queryUsersBySql(data);
 }

 public String register(@RequestBody String id,String name ,String tel, String password) {
	return studentMapper.register(id,name,tel,password);
	 
 }
public String login(@RequestBody String id,String password) {
	return studentMapper.login(id,password);
}
public String count(@RequestBody String stuClass ) {
	return studentMapper.count(stuClass);
}

public String countstudent(String stuClass) {
	return studentMapper.count(stuClass);
}



}