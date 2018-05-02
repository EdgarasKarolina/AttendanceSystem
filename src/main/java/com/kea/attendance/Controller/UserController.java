package com.kea.attendance.Controller;

import com.kea.attendance.Service.EnrolledStudentsService;
import com.kea.attendance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    /*
    @GetMapping("/courses")
    public String allCourses(Model model) {

        String amountOfCourses = service.getAllCoursesForStudent();
        model.addAttribute("say", amountOfCourses);
        return "coursesview";
    }  */
    @GetMapping("/users")
    public String allStudent(Model model) {

        int amountOfUsers = userService.getAll().size();
        String string = String.valueOf(amountOfUsers);
        model.addAttribute("say", string);
        return "coursesview";
    }

}
