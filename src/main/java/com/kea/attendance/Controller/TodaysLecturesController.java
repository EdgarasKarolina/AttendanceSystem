package com.kea.attendance.Controller;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Model.User;
import com.kea.attendance.Service.TodaysLecturesService;
import com.kea.attendance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TodaysLecturesController {



    @Autowired
    TodaysLecturesService todaysLecturesService;

    @Autowired
    UserService userService;
    
    @GetMapping("/todaysLectureStudent")
    public String root(Model model) {

        getLectures(model);
        return "todays_students_lectures";

    }

    @RequestMapping(value = "/reportService", method = RequestMethod.GET)
    public String toReportService() {

        return "microServiceReport";
    }

    @GetMapping("/todaysLectureTeacher")
    public String teacherLecture (Model model) {



        getLectures(model);


        return "teachersLectures";
    }

    private Model getLectures(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        System.out.println(user.getId());
        List<TodaysLectures> results = this.todaysLecturesService.getStudentCourse(user.getId());


        return model.addAttribute("results", results);


        }
}