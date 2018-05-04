package com.kea.attendance.Repository;

import com.kea.attendance.Model.AttendanceCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceCodeRepository extends CrudRepository<AttendanceCode, Long>
{
    List<AttendanceCode> findAllByCodeAndLectureID(String code, int lectureID);
}
