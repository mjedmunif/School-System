package org.example.onetoone.Repository;

import org.example.onetoone.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher , Integer> {

    Teacher findTeacherById(Integer id);
}
