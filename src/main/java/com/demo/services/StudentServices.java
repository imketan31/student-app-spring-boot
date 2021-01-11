package com.demo.services;

import com.demo.Entities.Student;
import com.demo.dtos.LoginDtos;
import com.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServices {

    @Autowired public StudentRepository studentRepository;


    public List<Student> getAllStudentData() {

        return (List<Student>) studentRepository.findAll();
    }


    public Student getStudentDataByRollNo(String rollNo) {

        return  studentRepository.getStudentByRollNo(rollNo);
    }

    public Student addStudentData(Student student) {

        return studentRepository.save(student);
    }

    public void deleteStudentData(String rollNo) {
         Student student =  studentRepository.getStudentByRollNo(rollNo);
         studentRepository.delete(student);
    }

    public Student login(LoginDtos loginDtos) {
       return   studentRepository.login(loginDtos.getUserName(),loginDtos.getPass());

    }
}
