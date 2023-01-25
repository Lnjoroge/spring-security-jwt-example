package com.example.CRUD.Service;


import com.example.CRUD.Exception.ResourceNotFoundException;
import com.example.CRUD.Model.Student;
import com.example.CRUD.Repository.Erepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentS implements studentService{
 public Erepository erepository;

    public studentS(Erepository erepository) {
        this.erepository = erepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return erepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return erepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
//        Optional<Student> student = erepository.findById(id);
//
//        if(student.isPresent()){
//            return student.get();
//
//        }else{
//            throw new ResourceNotFoundException("Student", "id", id);
//        }

        return erepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
    }

    @Override
    public Student updateStudent(Student student, long id) {

        Student st = erepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        st.setEmailName(student.getEmailName());
        erepository.save(st);
        return st;
    }

    @Override
    public void deleteStudent(long id) {

        erepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student", "id", id));
        erepository.deleteById(id);
    }


}
