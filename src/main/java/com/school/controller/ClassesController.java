package com.school.controller;

import com.school.dataobject.Classes;
import com.school.dataobject.Result;
import com.school.repository.ClassesRepository;
import com.school.service.ClassesService;
import com.school.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/school/class")
public class ClassesController {

    private final static Logger logger = LoggerFactory.getLogger(ClassesController.class);

    @Autowired
    private ClassesService classesService;

    /**
     * 新建课程
     */
    @GetMapping("/add")
//    @CacheEvict(cacheNames = "class",key = "123")
    public Result<Classes> classAdd(@Valid Classes classes, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(classesService.addClass(classes));
    }

    /**
     * 编辑课程
     */
    @GetMapping("/update")
//    @CacheEvict(cacheNames = "class",key = "123")
    public Result<Classes> classUpdate(@Valid Classes classes, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(classesService.updateClass(classes));
    }

    /**
     * 删除课程
     */
    @GetMapping("/delete")
//    @CacheEvict(cacheNames = "class",key = "123")
    public Result<Classes> classDelete(int classID){
        classesService.deleteClass(classID);
        return ResultUtil.success("删除成功");
    }

    /**
     * 显示所有课程，这里需要修改
     */
    @GetMapping("/showAll")
//    @Cacheable(cacheNames = "class",key = "123",unless = "#result.getCode() != 0")
//    @Cacheable(cacheNames = "class",key = "123")
    public Result<Classes> classShowAll(){
        log.warn("执行方法，没有从redis中获取数据");
        List<Classes> classes = classesService.showAll();
        return ResultUtil.success(classes);
}


    /**
     * 显示所有课程内容，这里需要修改
     */
    @GetMapping("/showOne")
//    @Cacheable(cacheNames = "class",key = "123")
    public Result<Classes> classShowOne(int classID){
        return ResultUtil.success(classesService.showClass(classID));
    }

    /**
     * 根据教师ID查询课程
     */
    @GetMapping("/showByT")
//    @Cacheable(cacheNames = "class",key = "123")
    public Result<Classes> classShowT(int teacherId){
        return ResultUtil.success(classesService.showClassByTeacher(teacherId));
    }
}
