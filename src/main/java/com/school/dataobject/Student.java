package com.school.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 5238284263071284249L;

    @Id
    @GeneratedValue
    private int studentId;

//    @NotBlank(message = "姓名不能为空")
    private String studentName;

//    @NotBlank(message = "账号不能为空")
    private String studentAccount;

//    @NotBlank(message = "密码不能为空")
    private String studentPassword;

//    private String studentProject;

//    private String studentNowProject;

}
