package com.coaching.center.repository;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Student findByEmail(String email);

    Student findByStudentId(Long studentId);


}
