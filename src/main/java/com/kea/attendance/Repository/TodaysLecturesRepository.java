package com.kea.attendance.Repository;

import com.kea.attendance.Model.TodaysLectures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodaysLecturesRepository extends CrudRepository<TodaysLectures,Long>
{
    @Query(value =
            "SELECT date, name from Lecture, course WHERE CourseID IN (select courseID from enrolledstudents where studentID = ? AND date = curdate())",
            nativeQuery = true)
    List<TodaysLectures>  findAllByRoleId(Integer studentId);
}
