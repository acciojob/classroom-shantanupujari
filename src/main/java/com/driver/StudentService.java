package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository Repository;
    public void addStudent(@RequestBody Student student){
        Repository.addStudent(student);

    }
    public void addTeacher(@RequestBody Teacher teacher){
        Repository.addTeacher(teacher);

    }
    public void addStudentTeacherPair(@RequestParam String student ,@RequestParam String teacher){
        Repository.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(@PathVariable String name){
        Student student= Repository.getStudentByName(name);
        return student;
    }
    public Teacher getTeacherByName(String name ){
        Teacher teacher = Repository.getTeacherByName(name);
        return  teacher;
    }
    public List<String> getStudentByTeacherName(String name){
        return Repository.getStudentByTeacherName(name);
    }
    public List<String>getAllStudents(){
        return  Repository.getAllStudents();
    }
    public void deleteTeacherByName(String teacher){
        Repository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        Repository.deleteAllTeachers();
    }
}
