package org.example.onetoone.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.onetoone.API.APIResponse;
import org.example.onetoone.Model.Student;
import org.example.onetoone.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new APIResponse("Added student successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new APIResponse("updated student successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new APIResponse("deleted successfully"));
    }

    @GetMapping("/changeMajor/{studentId}/{newMajor}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer studentId , @PathVariable String newMajor){
        studentService.changeMajorStudent(studentId, newMajor);
        return ResponseEntity.status(200).body(new APIResponse("change major successfully"));
    }
}
