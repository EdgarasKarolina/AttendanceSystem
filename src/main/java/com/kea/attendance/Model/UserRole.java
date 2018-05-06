package com.kea.attendance.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="UserRole")
@IdClass(UserRole.class)
public class UserRole implements Serializable{

    @Id
    @Column(name = "userID")
    private int userID;

    @Id
    @Column(name = "roleID")
    private int roleID;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

}
