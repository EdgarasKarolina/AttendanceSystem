package com.kea.attendance.Controller;

import com.kea.attendance.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Edgaras on 27/04/2018.
 */
@Controller
public class CourseController
{
    @Autowired
    CourseService service;
}
