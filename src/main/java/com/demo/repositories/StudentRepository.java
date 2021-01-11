package com.demo.repositories;

import com.demo.Entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    @Query("select s from Student s WHERE s.rollNo =:rollno")
    Student getStudentByRollNo(@Param("rollno") String rollno);

    @Query("select s from Student s WHERE s.userName =:userName and s.pass =:pass")
    Student login(@Param("userName") String userName,@Param("pass") String pass);
}
