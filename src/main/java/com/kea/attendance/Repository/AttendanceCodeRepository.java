package com.kea.attendance.Repository;

import com.kea.attendance.Model.AttendanceCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AttendanceCodeRepository extends CrudRepository<AttendanceCode, Long>
{
    List<AttendanceCode> findAllByCodeAndLectureID(String code, int lectureID);

    @Query(value =
            "SELECT code from attendancecode WHERE lectureId=?",
            nativeQuery = true)
    String findCode(int lectureId);
    List<AttendanceCode> findAllByCodeAndLectureIDAndTimestampAfter(String code, int lectureID, Timestamp timestamp);
}
