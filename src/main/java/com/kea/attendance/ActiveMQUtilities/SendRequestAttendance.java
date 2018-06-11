package com.kea.attendance.ActiveMQUtilities;

import com.kea.attendance.Model.Attendance_Data_View;
import com.kea.attendance.Utilities.AttendanceRequest;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class SendRequestAttendance {
    public void sendData(AttendanceRequest attendanceRequest){

        AttedanceRequestRoute routeBuilder = new AttedanceRequestRoute();
        routeBuilder.passObject(attendanceRequest);

        CamelContext context = new DefaultCamelContext();

        //configure jms component
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        try{
            context.addRoutes(routeBuilder);
            context.start();

            //Thread.sleep(5 * 60 * 1000);
            //context.stop();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
