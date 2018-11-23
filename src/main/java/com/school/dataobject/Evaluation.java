package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Evaluation implements Serializable {

    private static final long serialVersionUID = -7974827060777953927L;

    @Id
    @GeneratedValue
    private int eId;

//    @NotNull(message = "评分不能为空")
    private int eGrade;

    private int classId;

    private String className;

    private int studentId;
}
