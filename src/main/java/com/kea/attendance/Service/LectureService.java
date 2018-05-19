package com.kea.attendance.Service;
import com.kea.attendance.Repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Service
public class LectureService
{
    LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository)
    {
        this.lectureRepository = lectureRepository;
    }

    public Lecture findLecture(int id){
        return this.lectureRepository.findByLectureId(id);
    }
}
