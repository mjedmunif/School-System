package org.example.onetoone.Repository;

import org.example.onetoone.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    Student findStudentById(Integer id);


    @Query("select s from Student s join s.courses c where c.id = ?1")
    List<Student> getStudentByCourseId(Integer courseId);
}
