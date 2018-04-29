package com.kea.attendance.Repository;

import com.kea.attendance.Model.EnrolledStudents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Edgaras on 28/04/2018.
 */
@Repository
public interface EnrolledStudentsRepository extends CrudRepository<EnrolledStudents,Long> {

    List<EnrolledStudents> findByStudentId(int studentId);
}
