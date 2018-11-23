package com.school.repository;

import com.school.dataobject.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes,Integer> {
    public List<Classes> findByteacherId(int teacherId);
}
