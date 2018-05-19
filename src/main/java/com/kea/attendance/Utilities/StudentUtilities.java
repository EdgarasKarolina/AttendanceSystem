package com.kea.attendance.Utilities;

public class StudentUtilities {

    private static String ipAddress = null;

    public static String getIP()
    {
        ipAddress = null;
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println("My current IP address is " + s.next());
            ipAddress = s.next();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }
}


