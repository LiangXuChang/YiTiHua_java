package com.school.service;

import com.school.dataobject.Question;

import java.util.List;

public interface QuestionService {

    //学生提出疑难问题
    Question addQuestion(Question question);

    //显示学生提出的疑难问题
    List<Question> showQuestion();

    //教师对疑难问题进行解答
    Question addAnswer(Question question);

    //根据问题id查询问题
    Question showOne(int qId);

    //根据学生id查询问题
    List<Question> showBySid(int StudentId);

    //根据课程id查询问题
    List<Question> showByCid(int ClassId);

}
