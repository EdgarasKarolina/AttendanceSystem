package com.kea.attendance.Controller;

import com.kea.attendance.Model.Attendance;
import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Service.AttendanceCodeService;
import com.kea.attendance.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class AttendanceCodeController
{
    @Autowired
    AttendanceCodeService attendanceCodeService;

    @Autowired
    AttendanceService attendanceService;

    String viewReturn = null;

    @PostMapping("/check")
    public String root(Model model, @RequestParam(name = "code") String code, @RequestParam(name = "ID") int ID,
                       @RequestParam(name = "courseID") int courseID) {

        List<AttendanceCode> results = this.attendanceCodeService.getAttendanceCodes(code, ID, new Timestamp(System.currentTimeMillis()));
        model.addAttribute("results", results);

        if (results.size() > 0)
        {
            System.out.println("RESULT IS VERY NICE");

            Attendance attendance = new Attendance();
            attendance.setStudentID(3);
            attendance.setLectureID(ID);
            attendance.setCourseID(courseID);
            attendance.setAttended(1);
            attendanceService.save(attendance);

            viewReturn = "confirmation";
        }

        else {
            viewReturn = "error";
        }
        return viewReturn;
    }

    /*
    @PostMapping("/check")
    public String root(Model model) {

        List<AttendanceCode> results = this.attendanceCodeService.getAttendanceCodes("111", 1, new Timestamp(System.currentTimeMillis()));
        model.addAttribute("results", results);

        System.out.println(results.size() + "------------------ This is the size");
        for (AttendanceCode item : results) {
            System.out.println(item.getCode());
            System.out.println(item.getTimestamp());
            System.out.println(item.getLectureID());
            System.out.println("-----------------------------------");
        }
        return "todays_students_lectures";
    } */


}
