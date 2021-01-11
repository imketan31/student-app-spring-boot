package com.demo.services;

import com.demo.Entities.ClassTeacher;
import com.demo.Entities.Student;
import com.demo.dtos.LoginDtos;
import com.demo.repositories.ClassTracherRepo;
import com.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTeacherServices {
@Autowired private StudentRepository studentRepository;
@Autowired private ClassTracherRepo classTracherRepo;
    public List<ClassTeacher> getAllClassTecher() {

        return (List<ClassTeacher>) classTracherRepo.findAll();
    }

    public ClassTeacher login(LoginDtos loginDtos) {
        return classTracherRepo.login(loginDtos.getUserName(),loginDtos.getPass());
    }
}
