package com.example.exam1.Service;

import com.example.exam1.Model.Student;
import com.example.exam1.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class StudentService {

    ArrayList<Student>students=new ArrayList<>();

    public ArrayList<Student> getStudents(){

       return students;
    }


    public boolean addStudent(Student student){

         return students.add(student);


    }

    public boolean updateStudent(Student student,Integer id){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }


        }
        return false;


    }

    public boolean deleteStudent(Integer id){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;


    }

    public Student findStudent(String name){
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;}








}
