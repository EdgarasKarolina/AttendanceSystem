package com.kea.attendance.Controller;

import com.kea.attendance.ActiveMQUtilities.SendRequestAttendance;
import com.kea.attendance.Model.User;
import com.kea.attendance.Service.UserService;
import com.kea.attendance.Utilities.AttendanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping(value={"/", "/login"})
    public String getLogin (){

        return "login";
    }

    /*@RequestMapping(value="home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome to our attendance system" + user.getName());
        modelAndView.setViewName("/home");
        return modelAndView;
    }*/

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
            throws IOException, ServletException {

        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //User user = userService.findUserByEmail(auth.getName());
        String role=authResult.getAuthorities().toString();

        if(role.contains("STUDENT")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/todaysLectureStudent"));
        }
        else if(role.contains("TEACHER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/todaysLectureTeacher"));
        }
        else{
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/admin_panel"));
        }
    }


    @RequestMapping(value="requestAttendanceReport", method = RequestMethod.POST)
    public String RequestAttedanceReport() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        AttendanceRequest attendanceRequest = new AttendanceRequest();
        attendanceRequest.setTypeOfRequest(1); // 1 for single student
        attendanceRequest.setEmail(auth.getName());
        attendanceRequest.addToList(user.getId());

        SendRequestAttendance SRA = new SendRequestAttendance();
        SRA.sendData(attendanceRequest);


        return "/confirmation";
    }

}
