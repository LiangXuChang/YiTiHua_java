package com.school.repository;

import com.school.dataobject.Prepare;
import com.school.dataobject.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    public List<Question> findByClassId(int classId);
    public List<Question> findBystudentAccount(int studentAccount);
}
