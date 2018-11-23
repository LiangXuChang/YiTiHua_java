package com.school.service;

import com.school.dataobject.Evaluation;

import java.util.List;

public interface EvaluationService {

    //手动评分
    Evaluation add(Evaluation evaluation);

    //显示评分
    Evaluation show(int EId);

    //根据学生id获取对象
    List<Evaluation> showBySid(int studentId);
    //自动评分
}
