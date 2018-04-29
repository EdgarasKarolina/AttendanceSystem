package com.kea.attendance.Service;

import com.kea.attendance.Model.Course;
import com.kea.attendance.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edgaras on 27/04/2018.
 */
@Service
public class CourseService
{
    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    public String getAll()
    {
        List<Course> list = (List<Course>) courseRepository.findAll();
        return String.valueOf(list.size());
    }

/*
    public List<Course> listOfCoursesForStudent(int id)
    {

    }
    */
}
