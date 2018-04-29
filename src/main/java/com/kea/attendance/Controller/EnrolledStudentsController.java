package com.kea.attendance.Controller;

import com.kea.attendance.Model.EnrolledStudents;
import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Service.CourseService;
import com.kea.attendance.Service.EnrolledStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Controller
public class EnrolledStudentsController {

    @Autowired
    EnrolledStudentsService service;

  /*  @GetMapping("/courses")
    public String allCourses(Model model) {

        String amountOfCourses = service.getAllCoursesForStudent();
        model.addAttribute("say", amountOfCourses);
        return "coursesview";
    } */

   /* @GetMapping("/courses")
    public String allCourses(Model model) {

        //model.addAttribute("say", amountOfCourses);
        return "coursesview";
    } */

    @GetMapping("/courses")
    public String getTodayLectures(Model model) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");


        TodaysLectures day1 = new TodaysLectures("2012-10-15", "Software design");
        TodaysLectures day2 = new TodaysLectures("2012-10-16", "DLS");
        TodaysLectures day3 = new TodaysLectures("2012-10-17", "Artificial inteligence");
        TodaysLectures day4 = new TodaysLectures("2012-10-18", "Java");
        List<TodaysLectures> listOfTodaysLectures = new LinkedList<>();
        listOfTodaysLectures.add(day1);
        listOfTodaysLectures.add(day2);
        listOfTodaysLectures.add(day3);
        listOfTodaysLectures.add(day4);

        model.addAttribute("todaysLectures", listOfTodaysLectures);
        return "todays_students_lectures_";
    }
}
