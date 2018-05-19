package com.kea.attendance.Service;

import com.kea.attendance.Model.*;
import com.kea.attendance.Repository.*;
import com.kea.attendance.Utilities.AdminUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    //Used repositories
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;
    CourseRepository courseRepository;
    LectureRepository lectureRepository;
    EnrolledStudentsRepository enrolledStudentsRepository;


    //Constructor
    @Autowired
    public AdminService(UserRepository userRepository,
                        UserRoleRepository userRoleRepository,
                        CourseRepository courseRepository,
                        EnrolledStudentsRepository enrolledStudentsRepository,
                        LectureRepository lectureRepository){

        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.courseRepository = courseRepository;
        this.lectureRepository = lectureRepository;
        this.enrolledStudentsRepository = enrolledStudentsRepository;
    }

    //USER FUNCTIONS
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Transactional
    public void deleteByEmail(String email) {

        User user = this.userRepository.getByEmail(email);
        this.userRoleRepository.deleteByUserID(user.getId());
        this.userRepository.delete(user);
    }


    public User findUserByEmail(String email){
        User user = this.userRepository.getByEmail(email);
        return user;
    }


    //ROLE FUNCTIONS
    public void saveRole(UserRole userRole){
        this.userRoleRepository.save(userRole);
    }


    //COURSE FUNCTIONS
    public void saveCourse(Course course){
        this.courseRepository.save(course);
    }

    @Transactional
    public void deleteCourseByName(String name){
        this.courseRepository.deleteByName(name);
    }

    public Course findByName(String name) {
        return this.courseRepository.findByName(name);
    }

    public Course findCourseByID(int id){
        return this.courseRepository.findById(id);
    }


    //ENROLLED STUDENTS FUNCTIONS
    public void saveEnrolledStudent(EnrolledStudents enrolledStudents){
        this.enrolledStudentsRepository.save(enrolledStudents);
    }

    @Transactional
    public void deleteEnrolledStudents(String courseName){
        Course course = this.courseRepository.findByName(courseName);
        this.enrolledStudentsRepository.deleteAllByCourseId(course.getId());
    }

    //TODO
    public List<EnrolledStudents> findAllEnrolledStudentsForCourse(int courseID){
        return this.enrolledStudentsRepository.findAllByCourseId(courseID);
    }

    //LECTURE FUNCTIONS
    public void saveLecture(Lecture lecture){
        this.lectureRepository.save(lecture);
    }


    //Search for lectures (CourseName, Date)
    public List<Lecture> findLectures(String courseName, String date){
        List<Lecture> lectures = null;
        AdminUtilities adminUtilities = new AdminUtilities();

        Course course = this.courseRepository.findByName(courseName);
        int courseID = course.getId();
        java.sql.Date formattedDate = adminUtilities.formatDate(date);

        lectures = this.lectureRepository.findAllByCourseIdAndDate(courseID, formattedDate);
        return lectures;
    }

    @Transactional
    public void deleteLectureByID(int id){
        this.lectureRepository.deleteByLectureId(id);
    }

    public Lecture findLectureById(int id){
        Lecture lecture = this.lectureRepository.findByLectureId(id);
        return lecture;
    }
}
