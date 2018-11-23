package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
public class Implementation implements Serializable {

    private static final long serialVersionUID = -1791468752633689122L;

    @Id
    @GeneratedValue
    private int implId;

    private int studentId;

    private int classId;

    private String className;

//    @NotBlank(message = "实训内容不能为空")
    private String implFont;

    private String implImg;

    private String implVideo;

    private String studentName;

}
