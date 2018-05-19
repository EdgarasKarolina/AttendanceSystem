package com.kea.attendance.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

public class AdminUtilities {

    public String passwordGenerator(String email)
    {
        String password = email.split("@")[0];
        return password;
    }


    public Date addDaysToDate(java.sql.Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        java.util.Date utilDate = c.getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }

    public Date formatDate(String date){
        java.sql.Date date_date = java.sql.Date.valueOf(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date_date);
        java.util.Date utilDate = c.getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }
}
