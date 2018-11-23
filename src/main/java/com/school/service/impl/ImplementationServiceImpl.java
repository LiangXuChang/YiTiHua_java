package com.school.service.impl;

import com.school.dataobject.Implementation;
import com.school.dataobject.Student;
import com.school.repository.ImplementationRepository;
import com.school.repository.StudentRepository;
import com.school.service.ImplementationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementationServiceImpl implements ImplementationService {

    @Autowired
    private ImplementationRepository implementationRepository;

//    @Autowired
//    private StudentRepository studentRepository;

    public Implementation uploadImg(Implementation implementation){
        implementation.setClassId(implementation.getClassId());
        implementation.setClassName(implementation.getClassName());
        implementation.setStudentId(implementation.getStudentId());
        implementation.setStudentName(implementation.getStudentName());
        implementation.setImplImg(implementation.getImplImg());
        implementation.setImplFont(implementation.getImplFont());
        implementation.setImplVideo(implementation.getImplVideo());
//        implementation.setClassId(implementation.getClassId());
        return implementationRepository.save(implementation);
    }

    //学生进行相关资源上传
    public Implementation addImpl(Implementation implementation){

//        Student student = new Student();
//        student.setStudentNowProject(implementation.getClassName());
//        studentRepository.save(student);

        implementation.setClassId(implementation.getClassId());
        implementation.setClassName(implementation.getClassName());
        implementation.setStudentId(implementation.getStudentId());
        implementation.setStudentName(implementation.getStudentName());
        implementation.setImplImg(implementation.getImplImg());
        implementation.setImplFont(implementation.getImplFont());
        implementation.setImplVideo(implementation.getImplVideo());
        return implementationRepository.save(implementation);
    }

    //显示所有学生上传的资源
    public List<Implementation> showImplAll(){
        return implementationRepository.findAll();
    }

    //显示单个学生上传的资源
    public Implementation showImplOne(int ImplId){
        return implementationRepository.findById(ImplId).get();
    }

    //根据课程id查询学生上传的实训
    public List<Implementation> showImplByClassId(int classId){
        return implementationRepository.findByClassId(classId);
    }

}
