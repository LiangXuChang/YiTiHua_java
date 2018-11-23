package com.school.controller;

import com.school.dataobject.Question;
import com.school.dataobject.Result;
import com.school.service.QuestionService;
import com.school.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/school/question")
public class QuestionController {

    private final static Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    /**
     * 学生提出疑难问题
     */
    @GetMapping("/add")
    public Result<Question> addQuestion(@Valid Question question, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(questionService.addQuestion(question));
    }

    /**
     * 显示学生提出的疑难问题
     */
    @GetMapping("/show")
    public Result<Question> showQuestion(){
        return ResultUtil.success(questionService.showQuestion());
    }

    /**
     * 教师对疑难问题进行解答
     */
    @GetMapping("/answer")
    public Result<Question> addAnswer(Question question){
        return ResultUtil.success(questionService.addAnswer(question));
    }

    /**
     * 根据学生id查询问题
     */
    @GetMapping("/showBySid")
    public Result<Question> showBySid(int studentAccount){
        return ResultUtil.success(questionService.showBySid(studentAccount));
    }

    /**
     * 根据课程id查询问题
     */
    @GetMapping("/showByCid")
    public Result<Question> showByCid(int classId){
        return ResultUtil.success(questionService.showByCid(classId));
    }

    /**
     * 根据问题id查询问题
     */
    @GetMapping("/showOne")
    public Result<Question> showOne(int qId){
        return ResultUtil.success(questionService.showOne(qId));
    }
}
