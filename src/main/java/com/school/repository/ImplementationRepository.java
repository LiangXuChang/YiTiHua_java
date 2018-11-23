package com.school.repository;

import com.school.dataobject.Implementation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImplementationRepository extends JpaRepository<Implementation,Integer> {
    public List<Implementation> findByClassId(int classId);
}
