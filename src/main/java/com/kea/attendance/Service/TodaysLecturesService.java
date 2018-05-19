package com.kea.attendance.Service;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Repository.TodaysLecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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









