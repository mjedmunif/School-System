package org.example.onetoone.Service;

import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIException;
import org.example.onetoone.DTO.DetailsTeacherDTO;
import org.example.onetoone.Model.Course;
import org.example.onetoone.Model.Teacher;
import org.example.onetoone.Repository.CourseRepository;
import org.example.onetoone.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void assignCourseToTeacher(Integer courseId , Integer teacherId){
        Course course = courseRepository.findCourseById(courseId);
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (course == null){
            throw new APIException("Course not found");
        }
        if (teacher == null){
            throw new APIException("Teacher not found");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    public void updateCourse(Integer id , Course course){
        Course findCourse = courseRepository.findCourseById(id);
        if (findCourse == null){
            throw new APIException("Course not found");
        }
        findCourse.setName(course.getName());
        courseRepository.save(findCourse);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new APIException("Course not found");
        }
        courseRepository.delete(course);

    }

    public DetailsTeacherDTO getNameTeacherByCourse(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null){
            throw new APIException("Course not found");
        }

        if (course.getTeacher() == null){
            throw new APIException("this course has no teacher");
        }
        return courseRepository.getDetailsTeacher(courseId);
    }
}
