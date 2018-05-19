package com.kea.attendance.Controller;

import com.kea.attendance.Model.Attendance;
import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Model.Lecture;
import com.kea.attendance.Model.User;
import com.kea.attendance.Service.AttendanceCodeService;
import com.kea.attendance.Service.AttendanceService;
import com.kea.attendance.Service.LectureService;
import com.kea.attendance.Service.UserService;

import com.kea.attendance.Utilities.StudentUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Controller
public class AttendanceCodeController
{
    @Autowired
    AttendanceCodeService attendanceCodeService;

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    LectureService lectureService;

    @Autowired
    UserService userService;

    String viewReturn = null;



    @PostMapping("/check")
    public String root(Model model, @RequestParam(name = "code") String code, @RequestParam(name = "ID") int ID,
                         @RequestParam(name = "courseID") int courseID) {

        String IP = StudentUtilities.getIP();
        IP = IP.substring(0, 5);

        List<AttendanceCode> results = this.attendanceCodeService.getAttendanceCodes(code, ID, new Timestamp(System.currentTimeMillis()));
        model.addAttribute("results", results);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());



        // TODO Please look at it if THERE ARE PROBLEMS
        if (results.size() > 0 && IP.equals("94.18"))
        {
            Attendance attendance = attendanceService.findByLectureIDandStudentID(ID, user.getId());
            Lecture lecture = lectureService.findLecture(ID);
            attendance.setAttendedTime(lecture.getAmountOfTime());
            attendance.setAttended(1);
            attendanceService.save(attendance);

            viewReturn = "confirmation";
        }
        else if (results.size() == 0 && IP.equals("94.18")){
            viewReturn = "incorectCode";
        }
        else if (results.size() > 0 && !IP.equals("94.18")){
            viewReturn = "wrongNetwork";
        }
        else {
            viewReturn = "wrongCode";
        }
        return viewReturn;
    }

    @GetMapping("/generateCode/{id}")
    public String generateCode(@PathVariable int id, Model model) {
        AttendanceCode existingCode =this.attendanceCodeService.findCode(id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()+300000); // Add 5 minutes to(300000 mili. sec.

        if(existingCode!=null){
            existingCode.setTimestamp(timestamp);
            this.attendanceCodeService.uupdateTimeStamp(existingCode);
            model.addAttribute("code",existingCode.getCode());
            return "generateCode";
        }

        String random = UUID.randomUUID().toString().replace("-", "");;
        String code = random.substring( 0, 10 );
        AttendanceCode attendanceCode = new AttendanceCode(timestamp,code,id);
        this.attendanceCodeService.insertAttendanceCode(attendanceCode);
        model.addAttribute("code",code);
        return "generateCode";
    }
}
