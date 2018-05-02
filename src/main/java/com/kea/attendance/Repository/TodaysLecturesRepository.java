package com.kea.attendance.Repository;

import com.kea.attendance.Model.EnrolledStudents;
import com.kea.attendance.Model.TodaysLectures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodaysLecturesRepository extends CrudRepository<TodaysLectures,Long>
{
    //@Query("select name from course name where ")
    //@Query("select course.name as coursename, lecture.date as lecturedate from userService us join us.service s where us.user.id = ?1")
    @Query("select course.name from course inner join enrolledstudents on course.ID=enrolledstudents.courseID where enrolledstudents.studentID=1")
    List<TodaysLectures> f ();
}
