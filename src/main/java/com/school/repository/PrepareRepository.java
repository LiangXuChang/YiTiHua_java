package com.school.repository;

import com.school.dataobject.Prepare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrepareRepository extends JpaRepository<Prepare,Integer> {
    public Prepare findByclassId(int classId);
}
