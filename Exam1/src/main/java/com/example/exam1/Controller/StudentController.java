package com.example.exam1.Controller;

import com.example.exam1.ApiResponse.ApiResponse;
import com.example.exam1.Model.Student;
import com.example.exam1.Model.Teacher;
import com.example.exam1.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/school/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ArrayList<Student> getAllStudent(){


        return studentService.getStudents();
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added "));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@RequestBody @Valid Student student,@PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean correctId=studentService.updateStudent(student,id);
        if(correctId){
            return ResponseEntity.status(200).body(new ApiResponse("the Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("the Student can not be updated"));

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        boolean correctId=studentService.deleteStudent(id);
        if(correctId){
            return ResponseEntity.status(200).body(new ApiResponse("the Student deleted"));

        }
           return ResponseEntity.status(400).body(new ApiResponse("the Student can not be deleted"));




    }

    @GetMapping("searchname/{name}")
    public ResponseEntity findTeacher(@PathVariable String name){
        Student found=studentService.findStudent(name);
        if (found != null){
            return ResponseEntity.status(200).body(studentService.findStudent(name));
        }
        return ResponseEntity.status(400).body(new ApiResponse("can not find the student"));

    }





}
