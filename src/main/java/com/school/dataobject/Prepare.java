package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
public class Prepare implements Serializable {

    private static final long serialVersionUID = 3733691659479957539L;

    @Id
    @GeneratedValue
    private int pId;

    private int teacherId;

    private int classId;

//    @NotBlank(message = "教程内容不能为空")
    private String pTFont;

    private String pTImg;

    private String pVideo;

//    @NotBlank(message = "考核点不能为空")
    private String pAssessment;

}
