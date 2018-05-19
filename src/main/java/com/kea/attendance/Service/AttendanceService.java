package com.kea.attendance.Service;

import com.kea.attendance.Model.Attendance;
import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Repository.AttendanceCodeRepository;
import com.kea.attendance.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService
{
    AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository)
    {
        this.attendanceRepository = attendanceRepository;
    }

    public void save(Attendance attendance) {

        attendanceRepository.save(attendance);
    }


    public Attendance findByLectureIDandStudentID(int lectureID, int studentID){
        return attendanceRepository.findByLectureIDAndStudentID(lectureID, studentID);
    }
}
