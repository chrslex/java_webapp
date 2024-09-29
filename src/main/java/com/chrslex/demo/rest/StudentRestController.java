package com.chrslex.demo.rest;


import com.chrslex.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("firstName", "lastName"));
        students.add(new Student("firstName2", "lastName2"));
        students.add(new Student("firstName3", "lastName3"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // check
        if (studentId < 0 || studentId >= students.size()){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}
