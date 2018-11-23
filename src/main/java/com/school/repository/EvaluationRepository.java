package com.school.repository;

import com.school.dataobject.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {
    public List<Evaluation> findByStudentId(int studentId);
}
