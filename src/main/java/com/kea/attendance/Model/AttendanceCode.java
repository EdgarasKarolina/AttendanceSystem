package com.kea.attendance.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="attendancecode")
public class AttendanceCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long ID;

    public AttendanceCode() {
    }

    @Column(name="timestamp")

    private Timestamp timestamp;

    @Column(name="code")
    private String code;

    @Column(name="lectureID")
    private int lectureID;

    public AttendanceCode(Timestamp timestamp, String code, int lectureID) {
        this.timestamp = timestamp;
        this.code = code;
        this.lectureID = lectureID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }
}
