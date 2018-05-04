package com.kea.attendance.Service;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Repository.TodaysLecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TodaysLecturesService {

    TodaysLecturesRepository todaysLecturesRepository;

    @Autowired
    public TodaysLecturesService(TodaysLecturesRepository todaysLecturesRepository) {
        this.todaysLecturesRepository = todaysLecturesRepository;
    }

    public List<TodaysLectures> getStudentCourse(int studentId) {

        List<TodaysLectures> results = this.todaysLecturesRepository.findAllByRoleId(studentId);

        return results;
    }
}









