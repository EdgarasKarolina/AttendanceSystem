package com.kea.attendance.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Entity
@Table(name="lecture")
public class Lecture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int lectureId;

    @Column(name="courseID")
    private int courseId;

    @Column(name="date")
    private Date date;

    @Column(name="amountOfTime")
    private Time amountOfTime;

    @Column(name="classroom")
    private String classroom;

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getAmountOfTime() {
        return amountOfTime;
    }

    public void setAmountOfTime(Time amountOfTime) {
        this.amountOfTime = amountOfTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
