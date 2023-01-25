package com.example.CRUD.Service;

import com.example.CRUD.Model.Student;

import java.util.List;

public interface studentService {
//    post
    Student saveStudent(Student student);
//    get all
    List<Student> getStudents();
//    get by id
    Student getStudentById(Long id);
//    update
    Student updateStudent(Student student, long id);
//    delete
    void deleteStudent(long id);
}
