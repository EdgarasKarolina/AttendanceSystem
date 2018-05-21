package com.kea.attendance.Model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User
{
    @Id
    @Column(name="userID")
    private int id;

    @Column(name="active")
    private int active;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="password")
    private String password;

    /* TODO Don't know what this is used for. Works perfectly without.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userrole", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    */
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
