package com.kea.attendance.Service;

import com.kea.attendance.Model.AttendanceCode;
import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Repository.AttendanceCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public List<AttendanceCode> getAttendanceCodes(String code, int lectureID, Timestamp timestamp) {

        List<AttendanceCode> results = this.attendanceCodeRepository.findAllByCodeAndLectureIDAndTimestampAfter(code, lectureID, timestamp);

        return results;
    }
}
