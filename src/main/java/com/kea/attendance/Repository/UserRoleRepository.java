package com.kea.attendance.Repository;

import com.kea.attendance.Model.UserRole;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;

@Table(name="UserRole")
public interface UserRoleRepository extends CrudRepository<UserRole,UserRole> {
    void deleteByUserID(int ID);
}
