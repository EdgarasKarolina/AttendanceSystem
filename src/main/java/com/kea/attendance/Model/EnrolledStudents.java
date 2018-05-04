package com.kea.attendance.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Entity
@IdClass(EnrolledStudents.class)
@Table(name="enrolledstudents")
public class EnrolledStudents implements Serializable {

    @Id
    @Column(name="studentid")
    private int studentId;

    //@Id
    @Column(name="courseID")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
