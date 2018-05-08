package com.kea.attendance.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StudentUtilities {
    static InetAddress[] interfacesList = null;
    public static String NOT_SET = "NOT_SET";
    private static final String DEFAULT_GATEWAY = "Default Gateway";
    private static String ipAddress = null;

    public static InetAddress[] interfacesList() {
        try {
            InetAddress networks = InetAddress.getLocalHost();
            interfacesList = InetAddress.getAllByName(networks.getCanonicalHostName());
            //interfacesList = InetAddress.getByName(networks.getCanonicalHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        for (InetAddress item : interfacesList) {
            System.out.println(item.toString());
        }

        return interfacesList;
    }

    public static String getIP() {
        String ip = NOT_SET;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "netsh interface ip show addresses \"Wi-Fi\"");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                //line = r.readLine();
                if (line.contains("IP Address")) {
                    ip = line.split("\\s+")[3];
                    //System.out.println(ip);
                    return ip;
                }
            }
        } catch (IOException ex) {
            //Logger.getLogger(Extractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip;
    }

    public static String getConnectedSSID() {
        String ssid = NOT_SET;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "netsh wlan show interfaces");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                //line = r.readLine();
                if (line.contains("SSID")) {
                    ssid = line.split("\\s+")[3];
                    System.out.println(ssid);
                    return ssid;
                }
            }
        } catch (IOException ex) {
        }
        return ssid;
    }

    public static String getDefaultGateway() {
        try {
            Process process = Runtime.getRuntime().exec("ipconfig");

            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.trim().startsWith(DEFAULT_GATEWAY)) {
                        String ipAddress = line.substring(line.indexOf(":") + 1).trim(),
                                routerURL = String.format("http://%s", ipAddress);
                    }
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }
}


