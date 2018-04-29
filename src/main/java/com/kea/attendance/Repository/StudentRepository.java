package com.kea.attendance.Repository;

import com.kea.attendance.Model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edgaras on 27/04/2018.
 */

//@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
