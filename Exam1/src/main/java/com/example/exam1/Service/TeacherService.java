package com.example.exam1.Service;

import com.example.exam1.Model.Student;
import com.example.exam1.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher>teachers=new ArrayList<>();


    public ArrayList<Teacher> getTeachers(){

        return teachers;
    }


    public boolean addTeacher(Teacher teacher){

        return teachers.add(teacher);


    }

    public boolean updateTeacher(Teacher teacher,Integer id){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }


        }
        return false;


    }

    public boolean deleteTeacher(Integer id){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;


    }


    public Teacher findTeacher(Integer id){
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;}




}


