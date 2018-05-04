package com.kea.attendance.Service;

import com.kea.attendance.Model.Course;
import com.kea.attendance.Model.EnrolledStudents;
import com.kea.attendance.Repository.CourseRepository;
import com.kea.attendance.Repository.EnrolledStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Service
public class EnrolledStudentsService
{
    EnrolledStudentsRepository enrolledStudentsRepository;

    @Autowired
    public EnrolledStudentsService(EnrolledStudentsRepository enrolledStudentsRepository)
    {
        this.enrolledStudentsRepository = enrolledStudentsRepository;
    }

    /*
    public String getAllCoursesForStudent()
    {
        List<EnrolledStudents> list = (List<EnrolledStudents>) enrolledStudentsRepository.findByStudentId(3);
        return String.valueOf(list.size());
    } */


}
