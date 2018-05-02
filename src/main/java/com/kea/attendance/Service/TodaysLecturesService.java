package com.kea.attendance.Service;

import com.kea.attendance.Model.TodaysLectures;
import com.kea.attendance.Model.User;
import com.kea.attendance.Repository.TodaysLecturesRepository;
import com.kea.attendance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodaysLecturesService
{
    TodaysLecturesRepository todaysLecturesRepository;

    @Autowired
    public TodaysLecturesService(TodaysLecturesRepository todaysLecturesRepository)
    {
        this.todaysLecturesRepository = todaysLecturesRepository;
    }

    public List<TodaysLectures> getAll()
    {
        return (List<TodaysLectures>) todaysLecturesRepository.findAll();
    }

    public List<TodaysLectures> getAll2()
    {
        return (List<TodaysLectures>) todaysLecturesRepository.f();
    }
}
