package com.kea.attendance.Service;

import com.kea.attendance.Repository.EnrolledStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Service
public class EnrolledStudentsService
{
    EnrolledStudentsRepository enrolledStudentsRepository;

    @Autowired
    public EnrolledStudentsService(EnrolledStudentsRepository enrolledStudentsRepository)
    {
        this.enrolledStudentsRepository = enrolledStudentsRepository;
    }
}
