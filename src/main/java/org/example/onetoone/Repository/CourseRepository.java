package org.example.onetoone.Repository;

import org.example.onetoone.DTO.DetailsTeacherDTO;
import org.example.onetoone.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course , Integer> {
    Course findCourseById(Integer id);

    @Query("select new org.example.onetoone.DTO.DetailsTeacherDTO(c.teacher.name , c.name) from Course c where c.id = ?1 ")
    DetailsTeacherDTO getDetailsTeacher(Integer courseId);
}
