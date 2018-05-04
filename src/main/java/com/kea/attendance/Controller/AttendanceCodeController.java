package com.kea.attendance.Controller;

import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Service.AttendanceCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AttendanceCodeController
{
    @Autowired
    AttendanceCodeService attendanceCodeService;

    @GetMapping("/check")
    public String root(Model model) {

        List<AttendanceCode> results = this.attendanceCodeService.getAttendanceCodes("111", 1);
        model.addAttribute("results", results);

        System.out.println(results.size() + "------------------");
        for (AttendanceCode item : results) {
            System.out.println(item.getCode());
            System.out.println(item.getTimestamp());
            System.out.println(item.getLectureID());
            System.out.println("-----------------------------------");
        }

        return "todays_students_lectures";
    }
}
