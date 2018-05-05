package com.kea.attendance.Controller;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Service.TodaysLecturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodaysLecturesController {

    @Autowired
    TodaysLecturesService todaysLecturesService;


    private String role = "teacher";

    @GetMapping("/")
    public String root(Model model) {
        List<TodaysLectures> results = this.todaysLecturesService.getStudentCourse(1);

        model.addAttribute("results", results);

            if(role == "student"){
                return "todays_students_lectures";

            }
            return "teachersLectures";
    }
}
    /*
    @GetMapping("/")
    public String root( Model model) {
        List<Object[]> results = this.todaysLecturesService.getStudentCourse(1);
        System.out.println(results.size());



        model.addAttribute("results",results);
        return "courses";
    } */

