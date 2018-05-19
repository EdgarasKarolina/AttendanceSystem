package com.kea.attendance.Repository;

import com.kea.attendance.Model.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Repository
public interface LectureRepository extends CrudRepository<Lecture,Long>
{
    List<Lecture> findAllByCourseIdAndDate(int courseID, java.sql.Date date);

    void deleteByLectureId(int lectureID);

    Lecture findByLectureId(int lectureID);
}
