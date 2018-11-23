package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
public class Question implements Serializable {

    private static final long serialVersionUID = 4427733764655736985L;

    @Id
    @GeneratedValue
    private int qId;

    private int studentAccount;

    private String studentName;

    private int teacherId;

    private int classId;

//    @NotBlank(message = "问题内容不能为空")
    private String qFont;

    private String qImg;

    private String qVideo;

    private String aFont;

    private String aImg;

    private String aVideo;
}
