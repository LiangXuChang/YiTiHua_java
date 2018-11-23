package com.school.controller;

import com.school.dataobject.Prepare;
import com.school.dataobject.Result;
import com.school.service.PrepareService;
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
@RequestMapping("/school/prepare")
public class PrepareController {

    private final static Logger logger = LoggerFactory.getLogger(PrepareController.class);

    @Autowired
    private PrepareService prepareService;

    @GetMapping("/add")
    public Result<Prepare> prepareAdd(@Valid Prepare prepare, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(prepareService.addTutorial(prepare));
    }

    @GetMapping("/show")
    public Result<Prepare> prepareShow(int pId){
        return ResultUtil.success(prepareService.showTutorial(pId));
    }

    @GetMapping("/update")
    public Result<Prepare> prepareUpdate(@Valid Prepare prepare, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(prepareService.updateTutorial(prepare));
    }

    @GetMapping("/showByC")
    public Result<Prepare> classShowT(int classId){
        return ResultUtil.success(prepareService.showTutorialbyClassId(classId));
    }
}
