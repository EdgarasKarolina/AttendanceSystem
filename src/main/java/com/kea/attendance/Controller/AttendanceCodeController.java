package com.kea.attendance.Controller;

import com.kea.attendance.Model.Attendance;
import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Service.AttendanceCodeService;
import com.kea.attendance.Service.AttendanceService;
import com.kea.attendance.Utilities.StudentUtilities;
import org.springframework.beans.factory.annotation.Autowired;
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

    String viewReturn = null;

    @PostMapping("/check")
    public String root(Model model, @RequestParam(name = "code") String code, @RequestParam(name = "ID") int ID,
                       @RequestParam(name = "courseID") int courseID) {

        String networkName = StudentUtilities.getConnectedSSID();
        String IP = StudentUtilities.getIP();
        IP = IP.substring(0, 2);

        List<AttendanceCode> results = this.attendanceCodeService.getAttendanceCodes(code, ID, new Timestamp(System.currentTimeMillis()));
        model.addAttribute("results", results);

        if (results.size() > 0 && networkName.equals("KEA") && IP.equals("10"))
        {
            Attendance attendance = new Attendance();
            attendance.setStudentID(2);
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
