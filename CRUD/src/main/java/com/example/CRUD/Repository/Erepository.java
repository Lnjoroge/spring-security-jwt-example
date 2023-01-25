package com.example.CRUD.Repository;


import com.example.CRUD.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Erepository extends JpaRepository<Student, Long> {
}
