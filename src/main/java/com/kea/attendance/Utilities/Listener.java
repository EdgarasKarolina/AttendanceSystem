package com.kea.attendance.Utilities;

import com.kea.attendance.Model.User;
import com.kea.attendance.Service.AdminService;
import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.command.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class Listener {

    @Autowired
    AdminService adminService;

    @JmsListener(destination = "lala")
    public void receiveMessageFromTopic(Message message) throws JMSException, JAXBException, FileNotFoundException {
        ActiveMQBytesMessage msg = (ActiveMQBytesMessage) message;
        byte[] data = msg.getContent().getData();
        processByteMessage(data);
    }

    private void processByteMessage(byte[] data) throws JAXBException, FileNotFoundException {
        String s = new String(data);
        writeIntoFile(s);

        File xml = new File("C:\\Users\\Palko\\Desktop\\DLS_AttendanceSystem\\AttendanceSystem\\src\\main\\java\\com\\kea\\attendance\\File\\user.txt");

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(xml);
            NodeList nodeList = doc.getElementsByTagName("com.example.ExampleCamel.Mq.Model.Student");

            for(int i = 0; i < nodeList.getLength(); i++){

                Node node = nodeList.item(i);

                if(node.getNodeType()==Node.ELEMENT_NODE){

                    Element eElement = (Element) node;
                    User user = new User();
                    user.setId(Integer.parseInt(eElement.getElementsByTagName("userId").item(0).getTextContent()));
                    user.setActive(Integer.parseInt(eElement.getElementsByTagName("active").item(0).getTextContent()));
                    user.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                    user.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    user.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());

                    adminService.saveUser(user);

                }

            }

        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        }
    }

    public void writeIntoFile(String s) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("C:\\Users\\Palko\\Desktop\\DLS_AttendanceSystem\\AttendanceSystem\\src\\main\\java\\com\\kea\\attendance\\File\\user.txt");
        writer.write(s);
        writer.close();
    }


}
