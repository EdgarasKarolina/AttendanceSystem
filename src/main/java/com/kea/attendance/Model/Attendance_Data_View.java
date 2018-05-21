package com.kea.attendance.Model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="attendance_data")
@IdClass(Attendance_Data_View.class)
public class Attendance_Data_View implements Serializable{

    @Id
    @Column(name="CourseID")
    private int courseID;

    @Column(name="CourseName")
    private String courseName;

    @Id
    @Column(name="StudentID")
    private int studentID;

    @Column(name="StudentName")
    private String StudentName;

    @Column(name="StudentSurname")
    private String StudentSurname;

    @Column(name="TotalCourseMinutes")
    private int TotalCourseMinutes;

    @Column(name="AttendedTime")
    private int attendedMinutes;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentSurname() {
        return StudentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        StudentSurname = studentSurname;
    }

    public int getTotalCourseMinutes() {
        return TotalCourseMinutes;
    }

    public void setTotalCourseMinutes(int totalCourseMinutes) {
        TotalCourseMinutes = totalCourseMinutes;
    }

    public int getAttendedMinutes() {
        return attendedMinutes;
    }

    public void setAttendedMinutes(int attendedMinutes) {
        this.attendedMinutes = attendedMinutes;
    }
}
