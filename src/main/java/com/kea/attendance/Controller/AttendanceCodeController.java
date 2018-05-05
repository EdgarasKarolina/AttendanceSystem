package com.kea.attendance.Controller;

import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Service.AttendanceCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

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


    @GetMapping("/generateCode/{id}")
    public String generateCode(@PathVariable int id, Model model) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String random = UUID.randomUUID().toString().replace("-", "");;
        String code = random.substring( 0, 10 );

        AttendanceCode attendanceCode = new AttendanceCode(timestamp,code,id);
        String existingCode =this.attendanceCodeService.findCode(id);

        if(this.attendanceCodeService.findCode(id)!=null){
            model.addAttribute("code",existingCode);
            return "generateCode";
        }
        this.attendanceCodeService.insertAttendanceCode(attendanceCode);
        model.addAttribute("code",code);
        return "generateCode";
    }

}
