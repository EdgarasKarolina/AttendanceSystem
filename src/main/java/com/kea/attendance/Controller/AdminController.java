package com.kea.attendance.Controller;

import com.kea.attendance.Model.User;
import com.kea.attendance.Model.UserRole;
import com.kea.attendance.Service.AdminService;
import com.kea.attendance.Utilities.AdminUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "admin_panel", method = RequestMethod.GET)
    public String toAdminPanel(){
        return "admin_panel";
    }

    @RequestMapping(value = "/user_administration", method = RequestMethod.GET)
    public String toUserAdministration() {

        return "admin_user_management";
    }

    @RequestMapping(value = "add_user", method = RequestMethod.POST)
    public String addUser(@RequestParam(value="fname") String fName,
                          @RequestParam(value="lname") String lName,
                          @RequestParam(value="email") String email,
                          @RequestParam(value="userRole") int roleID
                          ) {
        //Used for generation of password
        AdminUtilities adminUtilities = new AdminUtilities();

        User user = new User();
        user.setName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setPassword(adminUtilities.passwordGenerator(email));
        user.setActive(1);
        this.adminService.saveUser(user);

        UserRole userRole = new UserRole();
        userRole.setUserID(user.getId());
        userRole.setRoleID(roleID);
        this.adminService.saveRole(userRole);

        return "admin_panel";
    }


    @RequestMapping(value = "delete_user", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value="deleteByEmail") String email){
        this.adminService.deleteByEmail(email);

        return "admin_panel";
    }

}
