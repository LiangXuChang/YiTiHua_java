package com.school.service.impl;

import com.school.dataobject.Classes;
import com.school.repository.ClassesRepository;
import com.school.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    public Classes addClass(Classes classes){
        classes.setTeacherId(classes.getTeacherId());
        classes.setClassAddress(classes.getClassAddress());
        classes.setClassHome(classes.getClassHome());
        classes.setClassLevel(classes.getClassLevel());
        classes.setClassName(classes.getClassName());
        classes.setClassProject(classes.getClassProject());
        classes.setClassProjectTime(classes.getClassProjectTime());
        classes.setClassTeacher(classes.getClassTeacher());
        classes.setClassTime(classes.getClassTime());
        return classesRepository.save(classes);
    }

    public Classes updateClass(Classes classes){
        classes.setClassId(classes.getClassId());
        classes.setClassAddress(classes.getClassAddress());
        classes.setClassHome(classes.getClassHome());
        classes.setClassLevel(classes.getClassLevel());
        classes.setClassName(classes.getClassName());
        classes.setClassProject(classes.getClassProject());
        classes.setClassProjectTime(classes.getClassProjectTime());
        classes.setClassTeacher(classes.getClassTeacher());
        classes.setClassTime(classes.getClassTime());
        classes.setTeacherId(classes.getTeacherId());
        return classesRepository.save(classes);
    }

    public void deleteClass(int classID){
        classesRepository.deleteById(classID);
    }

    public List<Classes> showAll(){
        return classesRepository.findAll();
    }

    public Classes showClass(int classID){
        return classesRepository.findById(classID).get();
    }

    public List<Classes> showClassByTeacher(int teacherId){
        return classesRepository.findByteacherId(teacherId);
    }

}
