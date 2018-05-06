package com.kea.attendance.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.sql.Date;

@IdClass(TodaysLectures.class)
@Entity
public class TodaysLectures implements Serializable
{

    @Id
    public int ID;

    @Id
    private Date date;

    @Id
    private String name;

    @Id
    private int courseID;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLectureId() {
        return ID;
    }

    public void setLectureId(int lectureId) {
        this.ID = ID;
    }    public int getCourseID() {
    return courseID;
}

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }


}
