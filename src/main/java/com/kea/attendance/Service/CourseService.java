package com.kea.attendance.Service;

import com.kea.attendance.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
