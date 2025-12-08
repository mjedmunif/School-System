package org.example.onetoone.Service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIException;
import org.example.onetoone.Model.Student;
import org.example.onetoone.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id , Student student){
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null){
            throw new APIException("Student Not found");
        }
        student1.setAge(student.getAge());
        student1.setCourses(student.getCourses());
        student1.setMajor(student.getMajor());
        student1.setName(student.getName());
        studentRepository.save(student1);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if (student == null){
            throw new APIException("Student not found");
        }
        studentRepository.delete(student);
    }

    public void changeMajorStudent(Integer studentId , String major){
        Student student = studentRepository.findStudentById(studentId);
        if (student == null){
            throw new APIException("Student not found");
        }
        if (major.equalsIgnoreCase(student.getMajor())){
            throw new APIException("Enter a major other than your current major");
        }
        student.setMajor(major);
        if (student.getCourses() != null){
            student.getCourses().clear();
        }

        studentRepository.save(student);
    }
}
