package com.kea.attendance.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="attendance")
public class Attendance implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="lectureID")
    private int lectureID;

    @Column(name="courseID")
    private int courseID;

    @Column(name="studentID")
    private int studentID;

    @Column(name="attended")
    private int attended;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }

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

    public int getAttended() {
        return attended;
    }

    public void setAttended(int attended) {
        this.attended = attended;
    }
}
