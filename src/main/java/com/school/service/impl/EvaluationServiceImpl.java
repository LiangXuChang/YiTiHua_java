package com.school.service.impl;

import com.school.dataobject.Evaluation;
import com.school.dataobject.Student;
import com.school.repository.EvaluationRepository;
import com.school.repository.ImplementationRepository;
import com.school.repository.StudentRepository;
import com.school.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

//    @Autowired
//    private StudentRepository studentRepository;

    public Evaluation add(Evaluation evaluation){

//        Student student = new Student();
//        student.setStudentProject(evaluation.getClassName());
//        studentRepository.save(student);

        evaluation.setEGrade(evaluation.getEGrade());
        evaluation.setClassId(evaluation.getClassId());
        evaluation.setClassName(evaluation.getClassName());
        evaluation.setStudentId(evaluation.getStudentId());
        return evaluationRepository.save(evaluation);
    }

    public Evaluation show(int EId){
        return evaluationRepository.findById(EId).get();
    }

    public List<Evaluation> showBySid(int studentId){
        return evaluationRepository.findByStudentId(studentId);
    }

}
