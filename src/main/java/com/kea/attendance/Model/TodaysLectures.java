package com.kea.attendance.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(TodaysLectures.class)
@Table(name="course")
@SecondaryTables({
        @SecondaryTable(name="enrolledstudents"),
        @SecondaryTable(name="user")
})
public class TodaysLectures implements Serializable
{
   // @Id
   // @Column(name="date", table="lecture")
    private Date date;

    @Id
    @Column(name="name", table="course")
    private String name;

    /*
    public TodaysLectures(Date date, String name)
    {
        this.date = date;
        this.name = name;
    } */

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
}
