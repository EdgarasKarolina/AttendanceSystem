package com.kea.attendance.Service;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Repository.TodaysLecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TodaysLecturesService {

    //@PersistenceContext
    //private EntityManager entityManager;
    //List<TodaysLectures> listOfTodaysLectures = new ArrayList<>();

    TodaysLecturesRepository todaysLecturesRepository;

    @Autowired
    public TodaysLecturesService(TodaysLecturesRepository todaysLecturesRepository) {
        this.todaysLecturesRepository = todaysLecturesRepository;
    }

    public List<Object[]> getStudentCourse(int studentId) {

        List<Object[]> results = this.todaysLecturesRepository.findAllByRoleId(studentId);

        return results;
    }

}

/*
    public List<TodaysLectures> getTodaysLectures(int studentID) {
        //"login" this is the name of your procedure
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getTodaysLectures");

        //Declare the parameters in the same order
        //query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        //query.registerStoredProcedureParameter(2, Date.class, ParameterMode.OUT);
        //query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("param_studentID", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("date", Date.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("name", String.class, ParameterMode.OUT);


        //Pass the parameter values
        //query.setParameter(1, studentID);
        query.setParameter("param_studentID", studentID);


        //Execute query
        query.execute();

        //Get output parameters
        TodaysLectures todaysLectures = new TodaysLectures();
        //todaysLectures.setDate((java.sql.Date) query.getOutputParameterValue(2));
        //todaysLectures.setName((String) query.getOutputParameterValue(3));

        todaysLectures.setDate((java.sql.Date) query.getOutputParameterValue("date"));
        todaysLectures.setName((String) query.getOutputParameterValue("name"));



        listOfTodaysLectures.add(todaysLectures);

        System.out.printf("---------------" + String.valueOf(listOfTodaysLectures.size()));

        return listOfTodaysLectures; //enter your condition
    } */


    //TodaysLecturesRepository todaysLecturesRepository;

    /*@Autowired
    public TodaysLecturesService(TodaysLecturesRepository todaysLecturesRepository)
    {
        this.todaysLecturesRepository = todaysLecturesRepository;
    }

   /* public List<TodaysLectures> getAll()
    {
        return (List<TodaysLectures>) todaysLecturesRepository.findAll();
    }

    public List<TodaysLectures> getAll2()
    {
        return (List<TodaysLectures>) todaysLecturesRepository.f();
    } */


