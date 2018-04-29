package com.kea.attendance.Controller;

import com.kea.attendance.Model.Course;
import com.kea.attendance.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Edgaras on 27/04/2018.
 */
@Controller
public class CourseController
{
    @Autowired
    CourseService service;

   /* @GetMapping("/courses")
    public String allCourses(Model model) {
            //List<Course> listOfCourses = service.getAll();

            String number = "nothing";
            if (service == null)
            {
                System.out.println("it is null");
            }
            else {
                number = service.getAll();
            }

            model.addAttribute("say", number);
            return "coursesview";
    } */



}
