package com.kea.attendance.ActiveMQUtilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kea.attendance.Model.Attendance_Data_View;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.SimpleBuilder;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

@Component
public class SimpleRouteBuilder extends RouteBuilder {

    String jsonInString = null;
    List<Attendance_Data_View> list;

    @Override
    public void configure() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(list);

        PrintWriter writer = new PrintWriter(new FileOutputStream("src\\main\\resources\\ActiveMQ\\StatisticsData\\Inputname.txt", true));
        writer.println(jsonInString);
        writer.close();

        from("file:src\\main\\resources\\ActiveMQ\\StatisticsData\\").split().tokenize("\n").to("jms:queue:sendStatistics");
    }


    public void passList(List<Attendance_Data_View> list){
        this.list = list;
    }
}
