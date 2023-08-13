package com.example.exam1.Controller;

import com.example.exam1.ApiResponse.ApiResponse;
import com.example.exam1.Model.Student;
import com.example.exam1.Model.Teacher;
import com.example.exam1.Service.StudentService;
import com.example.exam1.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/school/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping("/get")
    public ArrayList<Teacher> getAllTeacher(){

        return teacherService.getTeachers();
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean correctId= teacherService.updateTeacher(teacher,id);
        if(correctId){
            return ResponseEntity.status(200).body(new ApiResponse("the Teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("the Teacher can not be updated try other id"));

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        boolean correctId=teacherService.deleteTeacher(id);
        if(correctId){
            return ResponseEntity.status(200).body(new ApiResponse("the Teacher deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("the Teacher can not be deleted try other id"));




    }

    @GetMapping("searchId/{id}")
    public ResponseEntity findTeacher(@PathVariable Integer id){
          Teacher found=teacherService.findTeacher(id);
        if (found != null){
            return ResponseEntity.status(200).body(teacherService.findTeacher(id));
        }
       return ResponseEntity.status(400).body(new ApiResponse("can not find the teacher"));

    }




}
