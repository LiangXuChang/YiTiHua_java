package com.school.controller;

import com.school.dataobject.Implementation;
import com.school.dataobject.Result;
import com.school.service.ImplementationService;
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
@RequestMapping("/school/implementation")
public class ImplementationController {

    private final static Logger logger = LoggerFactory.getLogger(ImplementationController.class);

    @Autowired
    private ImplementationService implementationService;

    /**
     * 学生进行相关资源上传
     */
    @GetMapping("/add")
    public Result<Implementation> addImpl(@Valid Implementation implementation, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(implementationService.addImpl(implementation));
    }

    /**
     * 显示所有学生上传的资源
     */
    @GetMapping("/showAll")
    public Result<Implementation> showAll(){
        return ResultUtil.success(implementationService.showImplAll());
    }


    /**
     * 显示单个学生上传的资源
     */
    @GetMapping("/showOne")
    public Result<Implementation> showOne(int ImplId){
        return ResultUtil.success(implementationService.showImplOne(ImplId));
    }

    /**
     * 根据课程id查询实训
     */
    @GetMapping("/showByClassId")
    public Result<Implementation> showByClassId(int classId){
        return ResultUtil.success(implementationService.showImplByClassId(classId));
    }

//    @GetMapping("/ceshi")
//    public Result<Implementation> uploadImg(Implementation implementation){
//        return ResultUtil.success(implementationService.uploadImg(implementation));
//    }
}
