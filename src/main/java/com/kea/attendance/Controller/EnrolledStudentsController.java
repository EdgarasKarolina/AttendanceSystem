package com.kea.attendance.Controller;

import com.kea.attendance.Service.EnrolledStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Controller
public class EnrolledStudentsController {

    @Autowired
    EnrolledStudentsService service;

}
