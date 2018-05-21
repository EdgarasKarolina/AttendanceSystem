package com.kea.attendance.Controller;

import com.kea.attendance.Model.*;
import com.kea.attendance.Service.AdminService;
import com.kea.attendance.Service.AttendanceService;
import com.kea.attendance.Utilities.AdminUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AttendanceService attendanceService;


    //REDIRECTS
    @RequestMapping(value = "/admin_panel", method = RequestMethod.GET)
    public String toAdminPanel(){
        return "admin_panel";
    }

    @RequestMapping(value = "/user_administration", method = RequestMethod.GET)
    public String toUserAdministration() {

        return "admin_user_management";
    }

    @RequestMapping(value = "/course_administration", method = RequestMethod.GET)
    public String toCourseAdministration() {

        return "admin_course_management";
    }

    @RequestMapping(value = "/lecture_administration", method = RequestMethod.GET)
    public String toLectureAdministration() {

        return "admin_lecture_management";
    }

    @RequestMapping(value = "/lecture_list_administration", method = RequestMethod.GET)
    public String toAdminLectureList() {

        return "admin_lecture_list_management";
    }

    //USER
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

    //COURSE
    @RequestMapping(value = "add_course", method = RequestMethod.POST)
    public String addCourse(@RequestParam(value="course_name") String courseName,
                            @RequestParam(value="teacher_email") String teacherEmail
    ) {

        Course course = new Course();
        course.setName(courseName);
        this.adminService.saveCourse(course);

        if(teacherEmail != ""){
            User user = this.adminService.findUserByEmail(teacherEmail);

            EnrolledStudents enrolledStudents = new EnrolledStudents();
            enrolledStudents.setCourseId(course.getId());
            enrolledStudents.setStudentId(user.getId());
            this.adminService.saveEnrolledStudent(enrolledStudents);
        }

        return "admin_panel";
    }

    @RequestMapping(value = "delete_course", method = RequestMethod.POST)
    public String deleteCourse(@RequestParam(value="course_name_delete") String courseName){

        if(courseName != null)
        {
            this.adminService.deleteEnrolledStudents(courseName);
            this.adminService.deleteCourseByName(courseName);

        }
        return "admin_panel";
    }

    //Lecture //TODO Remove to much business logic from controller
    @RequestMapping(value = "add_lecture", method = RequestMethod.POST)
    public String addlecture(@RequestParam(value="lecture_name") String lectureName,
                             @RequestParam(value="date") String date,
                             @RequestParam(value="hours") String hours,
                             @RequestParam(value="minutes") String minutes,
                             @RequestParam(value="classroom") String classroom,
                             @RequestParam(value="weeks") int weeks){

        AdminUtilities adminUtilities = new AdminUtilities();
        java.sql.Date date1 = java.sql.Date.valueOf(date);
        int totalTimeInMinutes = (Integer.parseInt(hours)*60)+(Integer.parseInt(minutes));

        int i = 0;

        do{
            Lecture lecture = new Lecture();
            Course course = null;
            course = adminService.findByName(lectureName);
            lecture.setCourseId(course.getId());
            lecture.setDate(date1);
            lecture.setAmountOfTime(totalTimeInMinutes);
            lecture.setClassroom(classroom);
            this.adminService.saveLecture(lecture);

            //GET ALL STUDENTS FOR COURSE
            System.out.println(course.getId());
            List<EnrolledStudents> enrolledStudents = this.adminService.findAllEnrolledStudentsForCourse(course.getId());
            System.out.println(enrolledStudents.size());
            for (EnrolledStudents student: enrolledStudents) {

                Attendance attendance = new Attendance();
                attendance.setStudentID(student.getStudentId());
                attendance.setLectureID(lecture.getLectureId());
                attendance.setCourseID(course.getId());
                attendance.setAttended(0);
                attendance.setAttendedTime(0);
                this.attendanceService.save(attendance);

            }
            date1 = adminUtilities.addDaysToDate(date1,7);

            i++;
        }
        while (i < weeks);

        return "admin_panel";
    }


    @RequestMapping(value = "show_lectures", method = RequestMethod.POST)
    public String showLectures(Model model,
                               @RequestParam(value="course_name2") String course_name,
                               @RequestParam(value="date2") String date){

        List<Lecture> lectures = this.adminService.findLectures(course_name, date);
        Course course = this.adminService.findByName(course_name);

        model.addAttribute("lectures", lectures);
        model.addAttribute("course", course);

        return "admin_lecture_list_management";
    }


    @RequestMapping(value = "delete_lecture_item", method = RequestMethod.POST)
    public String deleteLecture(Model model,
                                @RequestParam(value="lectureID") int lectureID,
                                @RequestParam(value="lectureDate") String lectureDate,
                                @RequestParam(value="courseName") String course_name){

        this.adminService.deleteLectureByID(lectureID);
        List<Lecture> lectures = this.adminService.findLectures(course_name, lectureDate);
        Course course = this.adminService.findByName(course_name);


        model.addAttribute("lectures", lectures);
        model.addAttribute("course", course);


        return "admin_lecture_list_management";
    }


}
