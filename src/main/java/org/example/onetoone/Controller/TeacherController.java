package org.example.onetoone.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIResponse;
import org.example.onetoone.Model.Teacher;
import org.example.onetoone.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity<?> getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new APIResponse("Added Teacher successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id , @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new APIResponse("Updated Teacher Info successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new APIResponse("deleted Teacher successfully"));
    }

    @GetMapping("/getTeacherDetails/{id}")
    public ResponseEntity<?> getTeacherWithDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetailsById(id));
    }

    @GetMapping("/getStudentByCourseId/{courseId}")
    public ResponseEntity<?> getStudentByCourseId(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(teacherService.getStudentByCourseId(courseId));
    }
}
