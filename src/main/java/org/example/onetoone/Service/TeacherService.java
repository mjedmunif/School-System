package org.example.onetoone.Service;
import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIException;
import org.example.onetoone.Model.Address;
import org.example.onetoone.Model.Course;
import org.example.onetoone.Model.Student;
import org.example.onetoone.Model.Teacher;
import org.example.onetoone.Repository.AddressRepository;
import org.example.onetoone.Repository.CourseRepository;
import org.example.onetoone.Repository.StudentRepository;
import org.example.onetoone.Repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id , Teacher teacher){
        Teacher findteacher = teacherRepository.findTeacherById(id);
        if (findteacher == null){
            throw new APIException("Teacher Not found");
        }
        findteacher.setAddress(teacher.getAddress());
        findteacher.setAge(teacher.getAge());
        findteacher.setEmail(teacher.getEmail());
        findteacher.setName(teacher.getName());
        findteacher.setSalary(teacher.getSalary());
        teacherRepository.save(findteacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new APIException("Teacher Not found");
        }
        teacherRepository.delete(teacher);
    }


    public Teacher getTeacherDetailsById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        Address address = addressRepository.findAddressByTeacherId(id);
        if (teacher == null){
            throw new APIException("teacher not found");
        }
        if (address == null){
            throw new APIException("teacher has no details");
        }
        return teacher;
    }

    public List<Student> getStudentByCourseId(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null){
            throw new APIException("Course Not found");
        }
        return studentRepository.getStudentByCourseId(courseId);
    }

}
