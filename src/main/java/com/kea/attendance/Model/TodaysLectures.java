package com.kea.attendance.Model;

import javax.persistence.Column;
import java.sql.Date;

public class TodaysLectures
{
    private String date;
    private String name;

    public TodaysLectures(String date, String name)
    {
        this.date = date;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
