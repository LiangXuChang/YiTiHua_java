package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.Student;
import com.school.service.StudentService;
import com.school.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/school/student")
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/create")
    public Result<Student> studentAdd(@Valid Student student, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(studentService.addStudent(student));
    }

    @GetMapping("/login")
    public @ResponseBody
    Result studentLogin(@RequestParam("studentAccount") String studentAccount,
                        @RequestParam("studentPassword") String studentPassword,
                        HttpServletResponse response){

            return ResultUtil.success(studentService.studentLogin(studentAccount,studentPassword,response));

    }

    @GetMapping("/display")
    public Result<Student> studentSelect(String studentAccount, HttpServletRequest request){

        return ResultUtil.success(studentService.showStudent(studentAccount,request));

    }

    @GetMapping("/logout")
//    @CacheEvict(cacheNames = "class",key = "123")
    public Result<Student> logout(HttpServletRequest request,
                                  HttpServletResponse response){

        return ResultUtil.success(studentService.logout(request,response));

    }
}
