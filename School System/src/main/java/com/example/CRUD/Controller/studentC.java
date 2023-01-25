package com.example.CRUD.Controller;

import com.example.CRUD.Model.Student;
import com.example.CRUD.Service.studentS;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin( origins = "http://localhost:4200")
public class studentC {

    private studentS students ;

    public studentC(studentS students) {
        this.students = students;
    }

//     create rest api
    @PostMapping("/postStudents")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(students.saveStudent(student),HttpStatus.CREATED);

  }
// get all Students
@GetMapping("/getStudent")
    public List<Student> getStudents(){
return students.getStudents();
    }
//    get by id
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentid){
return new ResponseEntity<Student>(students.getStudentById(studentid), HttpStatus.OK);
    }
//update
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        return new ResponseEntity<Student>(students.updateStudent(student,id), HttpStatus.OK);

    }
//    delete
    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id ){
        students.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);

    }
}


