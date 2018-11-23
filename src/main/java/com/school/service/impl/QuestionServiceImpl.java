package com.school.service.impl;

import com.school.dataobject.Question;
import com.school.repository.QuestionRepository;
import com.school.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    //学生提出疑难问题
    public Question addQuestion(Question question){
        question.setClassId(question.getClassId());
        question.setStudentName(question.getStudentName());
        question.setStudentAccount(question.getStudentAccount());
        question.setQFont(question.getQFont());
        question.setQImg(question.getQImg());
        question.setQVideo(question.getQVideo());
        return questionRepository.save(question);
    }

    //显示学生提出的疑难问题
    public List<Question> showQuestion(){
        return questionRepository.findAll();
    }

    //教师对疑难问题进行解答
    public Question addAnswer(Question question){
        question.setClassId(question.getClassId());
        question.setTeacherId(question.getTeacherId());
        question.setAFont(question.getAFont());
        question.setAImg(question.getAImg());
        question.setAVideo(question.getAVideo());
        return questionRepository.save(question);
    }

    //根据学生id查询问题
    public List<Question> showBySid(int studentAccount){
        return questionRepository.findBystudentAccount(studentAccount);
    }

    //根据课程id查询问题
    public List<Question> showByCid(int ClassId){
        return questionRepository.findByClassId(ClassId);
    }

    public Question showOne(int qId){
        return questionRepository.findById(qId).get();
    }
}
