package com.kea.attendance.Service;

import com.kea.attendance.Model.Student;
import com.kea.attendance.Model.User;
import com.kea.attendance.Repository.StudentRepository;
import com.kea.attendance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> getAll()
    {
        return (List<User>) userRepository.findAll();
    }
}
