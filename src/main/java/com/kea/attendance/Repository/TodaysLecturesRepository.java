package com.kea.attendance.Repository;

import com.kea.attendance.Model.TodaysLectures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodaysLecturesRepository extends CrudRepository<TodaysLectures,Long>
{
    @Query(value = "SELECT Lecture.date, Course.name, Lecture.ID, Lecture.courseID " +
            "FROM Lecture\n" +
            "INNER JOIN Course on Lecture.CourseID = Course.ID\n" +
            "WHERE Lecture.CourseID IN (select courseID from enrolledstudents where studentID = :studentId)\n" +
            "AND Lecture.date = curdate()\n" +
            "and Lecture.ID NOT IN (SELECT attendance.lectureID FROM attendance WHERE studentID = :studentId AND attended = 1)",
            nativeQuery = true)
    List<TodaysLectures>  findAllByRoleId(@Param("studentId")Integer studentId);
}
