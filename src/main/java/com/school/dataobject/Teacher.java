package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID = 8782291786046143589L;

    @Id
    @GeneratedValue
    private int teacherId;

//    @NotBlank(message = "账号不能为空")
    private String teacherAccount;

//    @NotBlank(message = "密码不能为空")
    private String teacherPassword;

//    @NotBlank(message = "姓名不能为空")
    private String teacherName;

//    private String teacherProject;

//    private String teacherNowProject;

}
