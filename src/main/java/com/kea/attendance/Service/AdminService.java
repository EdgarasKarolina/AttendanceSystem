package com.kea.attendance.Service;

import com.kea.attendance.Model.User;
import com.kea.attendance.Model.UserRole;
import com.kea.attendance.Repository.UserRepository;
import com.kea.attendance.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminService {
    //Used repositories
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;


    //Constructor
    @Autowired
    public AdminService(UserRepository userRepository, UserRoleRepository userRoleRepository){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    //Functions
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public void saveRole(UserRole userRole){
        this.userRoleRepository.save(userRole);
    }

    @Transactional
    public void deleteByEmail(String email) {

        User user = this.userRepository.getByEmail(email);
        this.userRoleRepository.deleteByUserID(user.getId());
        this.userRepository.delete(user);
    }

}
