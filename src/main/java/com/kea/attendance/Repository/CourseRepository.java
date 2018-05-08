package com.kea.attendance.Repository;

import com.kea.attendance.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Edgaras on 27/04/2018.
 */

@Repository
public interface CourseRepository extends CrudRepository<Course,Long>
{
    void deleteByName(String name);
    Course findByName(String name);
    Course findById(int id);

}
