package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.Teacher;
import com.school.service.TeacherService;
import com.school.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/school/teacher")
public class TeacherController {

    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/login")
    public @ResponseBody
    Result studentLogin(@RequestParam("teacherAccount") String teacherAccount,
                        @RequestParam("teacherPassword") String teacherPassword,
                        HttpServletResponse response){

        return ResultUtil.success(teacherService.teacherLogin(teacherAccount,teacherPassword,response));

    }

    @GetMapping("/display")
    public Result<Teacher> studentSelect(String teacherAccount, HttpServletRequest request){

        return ResultUtil.success(teacherService.showTeacher(teacherAccount,request));

    }

    @GetMapping("/logout")
    public Result<Teacher> logout(HttpServletRequest request,
                                  HttpServletResponse response){

        return ResultUtil.success(teacherService.logout(request,response));

    }
}
