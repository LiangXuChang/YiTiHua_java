package com.school.service;

import com.school.dataobject.Implementation;
import com.school.dataobject.Question;

import java.util.List;

public interface ImplementationService {

    //学生进行相关资源上传
    Implementation addImpl(Implementation implementation);

    //显示所有学生上传的资源
    List<Implementation> showImplAll();

    //显示单个学生上传的资源
    Implementation showImplOne(int ImplId);

    //根据课程id查询学生上传的实训
    List<Implementation> showImplByClassId(int classId);

    //上传图片
    Implementation uploadImg(Implementation implementation);

}
