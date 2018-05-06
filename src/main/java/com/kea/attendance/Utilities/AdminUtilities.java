package com.kea.attendance.Utilities;

public class AdminUtilities {

    public String passwordGenerator(String email)
    {
        String password = email.split("@")[0];
        return password;
    }
}
