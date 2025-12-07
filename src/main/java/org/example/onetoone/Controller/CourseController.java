package org.example.onetoone.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIResponse;
import org.example.onetoone.Model.Course;
import org.example.onetoone.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new APIResponse("added course successfully"));
    }

    @GetMapping("/assignCourseToTeacher/{courseId}/{teacherId}")
    public ResponseEntity<?> assignCourseToTeacher(@PathVariable Integer courseId , @PathVariable Integer teacherId){
        courseService.assignCourseToTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body(new APIResponse("Assigned course to teacher Successfully"));
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId , @RequestBody @Valid Course course){
        courseService.updateCourse(courseId, course);
        return ResponseEntity.status(200).body(new APIResponse("Updated course successfully"));
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(200).body(new APIResponse("Deleted course successfully"));
    }

    @GetMapping("/nameTeacherByCourse/{courseId}")
    public ResponseEntity<?> getNameTeacherBtCourseId(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(courseService.getNameTeacherByCourse(courseId));
    }

    @PutMapping("/assignStudentToCourse/{courseId}/{studentId}")
    public ResponseEntity<?> assignStudentToCourse(@PathVariable Integer courseId , @PathVariable Integer studentId){
        courseService.assignStudentToCourse(courseId, studentId);
        return ResponseEntity.status(200).body(new APIResponse("assign Student to course successfully"));
    }
}
