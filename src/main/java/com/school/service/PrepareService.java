package com.school.service;

import com.school.dataobject.Prepare;

public interface PrepareService {

    //添加教程
    Prepare addTutorial(Prepare prepare);

    //展示教程
    Prepare showTutorial(int pId);

    //修改教程
    Prepare updateTutorial(Prepare prepare);

    //根据课程id显示教程
    Prepare showTutorialbyClassId(int classId);

}
