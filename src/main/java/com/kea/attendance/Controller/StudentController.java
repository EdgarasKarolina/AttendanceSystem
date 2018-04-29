package com.kea.attendance.Controller;

/**
 * Created by Edgaras on 27/04/2018.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController
{
    @GetMapping("/students")
    public String allStudent() {
        return "studentsview";
    }
}
