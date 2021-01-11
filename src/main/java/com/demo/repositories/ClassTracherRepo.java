package com.demo.repositories;

import com.demo.Entities.ClassTeacher;
import com.demo.Entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTracherRepo extends CrudRepository<ClassTeacher ,String> {

    @Query("select s from ClassTeacher s WHERE s.userName =:userName and s.pass =:pass")
    ClassTeacher login(@Param("userName") String userName, @Param("pass") String pass);
}
