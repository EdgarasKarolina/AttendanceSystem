package com.kea.attendance.Utilities;


import com.kea.attendance.ActiveMQUtilities.SendMonthlyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    SendMonthlyData sendMonthlyData;

    //Seconds / Minutes / Hours / Day of the month / Month
    @Scheduled(cron="0 0 0 1 * ?")
    //@Scheduled(fixedRate = 5000)
    public void sendData(){
        try{
            this.sendMonthlyData.sendData();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
