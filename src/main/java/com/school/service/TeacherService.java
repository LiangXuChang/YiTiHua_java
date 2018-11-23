package com.school.service;

import com.school.dataobject.Result;
import com.school.dataobject.Teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface TeacherService {

    //教师登陆
    Result teacherLogin(String teacherAccount, String teacherPassword, HttpServletResponse response);

    //显示教师
    Result<Teacher> showTeacher(String teacherAccount, HttpServletRequest request);

    //教师登出
    Result logout(HttpServletRequest request, HttpServletResponse response);
}
