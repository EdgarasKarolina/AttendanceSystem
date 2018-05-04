package com.kea.attendance.Repository;

import com.kea.attendance.Model.EnrolledStudents;
import com.kea.attendance.Model.TodaysLectures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodaysLecturesRepository extends CrudRepository<TodaysLectures,Long>
{
    //@Query("select name from course name where ")
    //@Query("select course.name as coursename, lecture.date as lecturedate from userService us join us.service s where us.user.id = ?1")
    //@Query(value = "select course.name from course inner join enrolledstudents on course.ID=enrolledstudents.courseID where enrolledstudents.studentid=1", nativeQuery = true)
    //List<TodaysLectures> f ();
    @Query(value =
            "SELECT date, name from Lecture, course WHERE CourseID IN (select courseID from enrolledstudents where studentID = ? AND date = curdate())",
            nativeQuery = true)
    List<Object[]>  findAllByRoleId(Integer studentId);
}
