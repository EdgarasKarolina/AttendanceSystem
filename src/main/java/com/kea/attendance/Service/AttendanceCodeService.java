package com.kea.attendance.Service;
import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Repository.AttendanceCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceCodeService
{
    AttendanceCodeRepository attendanceCodeRepository;

    @Autowired
    public AttendanceCodeService(AttendanceCodeRepository attendanceCodeRepository)
    {
        this.attendanceCodeRepository = attendanceCodeRepository;
    }

    public List<AttendanceCode> getAttendanceCodes(String code, int lectureID) {

        List<AttendanceCode> results = this.attendanceCodeRepository.findAllByCodeAndLectureID(code, lectureID);

        return results;
    }

    public AttendanceCode insertAttendanceCode(AttendanceCode attendanceCode){

        return this.attendanceCodeRepository.save(attendanceCode);

    }

    public String findCode(int lectureId){
        return this.attendanceCodeRepository.findCode(lectureId);
    }


}
