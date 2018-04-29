package com.kea.attendance.Service;

import com.kea.attendance.Model.Student;
import com.kea.attendance.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edgaras on 27/04/2018.
 */
@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll()
    {
        return (List<Student>) studentRepository.findAll();
    }
}
