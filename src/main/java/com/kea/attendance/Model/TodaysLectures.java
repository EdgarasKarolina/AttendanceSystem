package com.kea.attendance.Model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Entity
public class TodaysLectures
{
    @Id
    private Date date;

    private String name;


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
