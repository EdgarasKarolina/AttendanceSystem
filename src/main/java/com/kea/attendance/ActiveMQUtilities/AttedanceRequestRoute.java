package com.kea.attendance.ActiveMQUtilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kea.attendance.Utilities.AttendanceRequest;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.PrintWriter;

@Component
public class AttedanceRequestRoute extends RouteBuilder{
    String jsonInString = null;
    AttendanceRequest attendanceRequest;

    @Override
    public void configure() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(attendanceRequest);
        //System.out.println(jsonInString);

        PrintWriter writer = new PrintWriter(new FileOutputStream("src\\main\\resources\\ActiveMQ\\StatisticsData\\AttendanceRequest.txt", true));
        writer.println(jsonInString);
        writer.close();

        from("file:src\\main\\resources\\ActiveMQ\\StatisticsData\\").split().tokenize("\n").to("jms:queue:AttendanceRequest");
    }


    public void passObject(AttendanceRequest attendanceRequest){
        this.attendanceRequest = attendanceRequest;
    }
}
