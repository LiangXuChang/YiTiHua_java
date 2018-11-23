package com.school.repository;

import com.school.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findBystudentAccount(String userAccount);
}
