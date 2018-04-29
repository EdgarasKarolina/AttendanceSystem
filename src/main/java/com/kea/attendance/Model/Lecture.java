package com.kea.attendance.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Entity
@IdClass(Lecture.class)
@Table(name="lecture")
public class Lecture implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int lectureId;

    @Id
    @Column(name="courseID")
    private int courseId;

    @Column(name="date")
    private Date date;

    @Column(name="amountOfTime")
    private Time amountOfTime;

    @Column(name="classroom")
    private String classroom;




}
