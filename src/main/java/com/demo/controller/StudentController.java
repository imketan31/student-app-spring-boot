package com.demo.controller;

import com.demo.Entities.ClassTeacher;
import com.demo.Entities.Student;
import com.demo.constants.StringConstants;
import com.demo.dtos.LoginDtos;
import com.demo.services.ClassTeacherServices;
import com.demo.services.StudentServices;
import com.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    public StudentServices studentServices;
    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public ClassTeacherServices classTeacherServices;


    @GetMapping(produces = "application/json")
    public ResponseEntity getStudentsInfo() {
        List<Student> students = studentServices.getAllStudentData();

        if (students != null && !students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "get-classteacher",produces = "application/json")
    public ResponseEntity getAllClassTeachers() {
        List<Student> students = studentServices.getAllStudentData();

        if (students != null && !students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "get-student-by-rollno", produces = "application/json")
    public ResponseEntity getStudentsInfobyRollNo(@RequestParam("rollno") String rollno) {
        Student students = studentServices.getStudentDataByRollNo(rollno);

        if (students != null) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity addStudentsInfo(@RequestBody Student student) {

        Student student1 = studentServices.addStudentData(student);
        if (student1 != null) {
            return ResponseEntity.ok(student1);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @PutMapping(produces = "application/json")
    public ResponseEntity editStudentsInfo(@RequestBody Student student) {


        Student student1 = studentServices.addStudentData(student);
        if (student1 != null) {
            return ResponseEntity.ok(student1);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(produces = "application/json")
    public ResponseEntity deleteeStudentsInfo(@RequestParam String rollNo) {
        Student student = studentRepository.getStudentByRollNo(rollNo);
        student.setStatus(StringConstants.DEACTIVE_STATUS);
        Student student1 = studentServices.addStudentData(student);

        if (student1 != null) {
            return ResponseEntity.ok(student1);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping(value = "login-student",produces = "application/json")
    public ResponseEntity loginStudent(@RequestBody LoginDtos loginDtos) {
        Student students = studentServices.login(loginDtos);

        if (students != null ) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "get-classTeacher",produces = "application/json")
    public ResponseEntity getAllClassTeacher() {
        List<ClassTeacher> allClassTecher = classTeacherServices.getAllClassTecher();

        if (allClassTecher != null && allClassTecher.size()>0) {
            return ResponseEntity.ok(allClassTecher);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "login-classteacher",produces = "application/json")
    public ResponseEntity loginClassTeacher(@RequestBody LoginDtos loginDtos) {

     ClassTeacher classTeacher = classTeacherServices.login(loginDtos);

        if (classTeacher != null ) {
            return ResponseEntity.ok(classTeacher);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
