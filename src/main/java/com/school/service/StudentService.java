package com.school.service;

import com.school.dataobject.Result;
import com.school.dataobject.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface StudentService {

    //学生注册
    Student addStudent(Student student);

    //学生登陆
    Result studentLogin(String studentAccount, String studentPassword,HttpServletResponse response);

    //显示学生信息
    Result<Student> showStudent(String studentAccount,HttpServletRequest request);

    //学生登出
    Result logout(HttpServletRequest request, HttpServletResponse response);
}
