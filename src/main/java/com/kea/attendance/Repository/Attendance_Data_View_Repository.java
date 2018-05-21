package com.kea.attendance.Repository;


import com.kea.attendance.Model.Attendance_Data_View;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Attendance_Data_View_Repository extends CrudRepository<Attendance_Data_View, Long> {
    @Query(value = "SELECT * FROM attendance_data", nativeQuery = true)
    List<Attendance_Data_View> findAlll ();
}