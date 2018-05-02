package com.kea.attendance.Controller;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Service.TodaysLecturesService;
import com.kea.attendance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodaysLecturesController
{
    @Autowired
    TodaysLecturesService todaysLecturesService;

    @GetMapping("/todayslectures")
    public String getTodaysLectures(Model model) {
        List<TodaysLectures> amountOfCourses = todaysLecturesService.getAll2();
        String amount = String.valueOf(amountOfCourses.size());
        model.addAttribute("say", amount);
        return "coursesview";
    }
}
