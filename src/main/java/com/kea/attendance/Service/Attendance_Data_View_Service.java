package com.kea.attendance.Service;

import com.kea.attendance.Model.Attendance_Data_View;
import com.kea.attendance.Repository.Attendance_Data_View_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Attendance_Data_View_Service {

    Attendance_Data_View_Repository repository;

    @Autowired
    public Attendance_Data_View_Service(Attendance_Data_View_Repository repository){
            this.repository = repository;
    }

    public List<Attendance_Data_View> getAll()
    {
        return this.repository.findAlll();
    }


}
