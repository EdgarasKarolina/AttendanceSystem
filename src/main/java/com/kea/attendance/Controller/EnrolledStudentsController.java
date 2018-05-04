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

}
