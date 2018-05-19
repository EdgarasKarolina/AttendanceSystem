package com.kea.attendance.Repository;

import com.kea.attendance.Model.EnrolledStudents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Repository
public interface EnrolledStudentsRepository extends CrudRepository<EnrolledStudents,Long>
{
    void deleteAllByCourseId(int CourseId);
}
