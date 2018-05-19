package com.kea.attendance.Repository;

import com.kea.attendance.Model.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long>
{
    Attendance findByLectureIDAndStudentID(int lectureID, int studentID);
}
