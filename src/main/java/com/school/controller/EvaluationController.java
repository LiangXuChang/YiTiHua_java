package com.school.controller;

import com.school.dataobject.Evaluation;
import com.school.dataobject.Result;
import com.school.service.EvaluationService;
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
@RequestMapping("/school/evaluation")
public class EvaluationController {

    private final static Logger logger = LoggerFactory.getLogger(EvaluationController.class);

    @Autowired
    private EvaluationService evaluationService;

    /**
     * 手动评分
     */
    @GetMapping("/add")
    public Result<Evaluation> add(@Valid Evaluation evaluation, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(evaluationService.add(evaluation));
    }


    /**
     * 显示评分
     */
    @GetMapping("/showAll")
    public Result<Evaluation> show(int EId){
        return ResultUtil.success(evaluationService.show(EId));
    }

    /**
     * 根据学生id获取对象
     */
    @GetMapping("/showBySid")
    public Result<Evaluation> showBySid(int studentId){
        return ResultUtil.success(evaluationService.showBySid(studentId));
    }
}
