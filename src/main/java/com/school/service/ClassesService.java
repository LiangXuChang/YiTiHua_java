package com.school.service;

import com.school.dataobject.Classes;

import java.util.List;

public interface ClassesService {

    //新建课程
    Classes addClass(Classes classes);

    //课程信息编辑
    Classes updateClass(Classes classes);

    //删除课程
    void deleteClass(int classID);

    //显示课程标题
    List<Classes> showAll();

    //显示单个课程信息
    Classes showClass(int classID);

    //根据教师ID显示课程
    List<Classes> showClassByTeacher(int teacherId);
}
