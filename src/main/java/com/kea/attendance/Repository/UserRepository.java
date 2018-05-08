package com.kea.attendance.Repository;

import com.kea.attendance.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User getByEmail(String email);

}
