package org.example.onetoone.Repository;

import org.example.onetoone.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    Student findStudentById(Integer id);
}
