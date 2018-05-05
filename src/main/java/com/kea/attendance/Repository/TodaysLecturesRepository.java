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
            "SELECT Lecture.date, Course.name, Lecture.ID, Lecture.courseID" +
                    " FROM Lecture" +
                    " INNER JOIN Course on Lecture.CourseID = Course.ID" +
                    " WHERE Lecture.CourseID IN (select courseID from enrolledstudents where studentID = ?)" +
                    " AND Lecture.date = curdate()",
            nativeQuery = true)
    List<TodaysLectures>  findAllByRoleId(Integer studentId);
}
