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
public class Classes implements Serializable {

    private static final long serialVersionUID = 5679027061172070314L;
    
    @Id
    @GeneratedValue
    private int classId;

    private int teacherId;

//    @NotBlank(message = "课程名称不能为空")
    private String className;

//    @NotBlank(message = "实训项目不能为空")
    private String classProject;

//    @NotNull(message = "课程学时不能为空")
    private int classTime;

//    @NotBlank(message = "课程难易程度不能为空")
    private String classLevel;

//    @NotBlank(message = "当前任课教师不能为空")
    private String classTeacher;

//    @NotBlank(message = "当前上课班级不能为空")
    private String classHome;

//    @NotBlank(message = "上课时间不能为空")
    private String classProjectTime;

//    @NotBlank(message = "上课地点不能为空")
    private String classAddress;
}
