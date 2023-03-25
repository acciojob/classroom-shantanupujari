package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
@Repository
public class StudentRepository {


    HashMap<String,Student> studentDB = new HashMap<>();
    HashMap<String ,Teacher> teacherDB = new HashMap<>();

    HashMap<String , List<String>> student_teacherDB = new HashMap<>();

    public void addStudent(Student student){
        String key = student.getName();
        studentDB.put(key,student);
    }
    public void addTeacher(Teacher teacher){
        String key= teacher.getName();
        teacherDB.put(key,teacher);
    }
    public void addStudentTeacherPair(@RequestParam String student ,@RequestParam String teacher){
            if (student_teacherDB.containsKey(teacher)){
                List<String>teacherList = student_teacherDB.get(teacher);
                teacherList.add(student);
                student_teacherDB.put(teacher,teacherList);
            }
            else {
                List<String>teacherList = new ArrayList<>();
                teacherList.add(teacher);
                student_teacherDB.put(teacher,teacherList);
            }

    }
    public Student getStudentByName(String name){
        Student student= studentDB.get(name);
        return student;
    }
    public Teacher getTeacherByName(String name){
        Teacher teacher = teacherDB.get(name);
        return teacher;
    }
    public List<String> getStudentByTeacherName(String name){
        return student_teacherDB.get(name);
    }
    public List<String> getAllStudents(){
        List<String>li = new ArrayList<>();
        for (String s : studentDB.keySet()){
            li.add(s);
        }
        return li;
    }
    public void deleteTeacherByName(String teacher){
        List<String> student_list = student_teacherDB.get(teacher);
        for(String s : student_list){
            studentDB.remove(s);
        }
        teacherDB.remove(teacher);
        student_teacherDB.remove(teacher);
    }
    public void deleteAllTeachers() {
        for (List<String> student_list : student_teacherDB.values()) {
            for (String s : student_list) {
                studentDB.remove(s);
            }
            teacherDB.clear();
            student_teacherDB.clear();
        }
    }
}
