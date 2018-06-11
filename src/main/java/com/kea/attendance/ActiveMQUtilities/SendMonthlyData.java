package com.kea.attendance.ActiveMQUtilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kea.attendance.Model.Attendance_Data_View;
import com.kea.attendance.Service.Attendance_Data_View_Service;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import java.util.List;

@Component
public class SendMonthlyData  {

    @Autowired
    Attendance_Data_View_Service ADVService;


    public void sendData() throws Exception {
        List<Attendance_Data_View> list = ADVService.getAll();

        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
        routeBuilder.passList(list);


        CamelContext context = new DefaultCamelContext();


        //configure jms component
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(routeBuilder);
        context.start();
        //Thread.sleep(5 * 60 * 1000);
        //context.stop();
    }



    /*
    @SendTo("${sendStatistics}")
    public String sendData(){
        List<Attendance_Data_View> list = ADVService.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try{
            jsonInString = mapper.writeValueAsString(list);
        }catch(Exception e){

        }
        //System.out.println("Sending: "+jsonInString);
        return jsonInString;
    }
    */

}
