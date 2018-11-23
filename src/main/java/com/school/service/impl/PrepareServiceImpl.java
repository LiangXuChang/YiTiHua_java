package com.school.service.impl;

import com.school.dataobject.Prepare;
import com.school.repository.PrepareRepository;
import com.school.service.PrepareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrepareServiceImpl implements PrepareService {

    @Autowired
    private PrepareRepository prepareRepository;

    public Prepare addTutorial(Prepare prepare){
        prepare.setClassId(prepare.getClassId());
        prepare.setTeacherId(prepare.getTeacherId());
        prepare.setPId(prepare.getPId());
        prepare.setPAssessment(prepare.getPAssessment());
        prepare.setPTFont(prepare.getPTFont());
        prepare.setPTImg(prepare.getPTImg());
        prepare.setPVideo(prepare.getPVideo());
        return prepareRepository.save(prepare);
    }

    public Prepare showTutorial(int pId){
        return prepareRepository.findById(pId).get();
    }

    public Prepare updateTutorial(Prepare prepare){
        prepare.setPId(prepare.getPId());
        prepare.setTeacherId(prepare.getTeacherId());
        prepare.setPAssessment(prepare.getPAssessment());
        prepare.setPTFont(prepare.getPTFont());
        prepare.setPTImg(prepare.getPTImg());
        prepare.setPVideo(prepare.getPVideo());
        return prepareRepository.save(prepare);
    }

    public  Prepare showTutorialbyClassId(int classId){
        return prepareRepository.findByclassId(classId);
    }
}
