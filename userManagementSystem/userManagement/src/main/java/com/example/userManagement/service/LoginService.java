package com.example.userManagement.service;


import com.example.userManagement.model.User;
import com.example.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    private MongoOperations mongoOperation;

    public String saveNewUser(String userName,String password,String fName,String lName,String emailId,int rollNumber,String hostel,int roomNumber,int passYear,boolean isTeacher){
        User newPlayerRecord= new User();
        newPlayerRecord.setUserName(userName);
        newPlayerRecord.setPassword(password);
        newPlayerRecord.setfName(fName);
        newPlayerRecord.setlName(lName);
        newPlayerRecord.setEmailId(emailId);
        newPlayerRecord.setRollNumber(rollNumber);
        newPlayerRecord.setHostel(hostel);
        newPlayerRecord.setRollNumber(roomNumber);
        newPlayerRecord.setPassYear(passYear);
        newPlayerRecord.setTeacher(isTeacher);
        User savedPlayer= (User) userRepository.save(newPlayerRecord);
        return savedPlayer.toString();
    }

    public String deleteStudent(String teacherUserName, String teacherPassword, String studentUserName) {
        Optional<User> teacherUser=userRepository.findItemByUserName(teacherUserName);
        if(teacherUser.isEmpty()) return "Please enter valid username";
        if(teacherUser.get().isTeacher()==false) return "Should be a teacher to delete";
        String givenPassword=teacherUser.get().getPassword();
        if(!givenPassword.equals(teacherPassword)) return "Please enter valid password";
        Optional<User> studentUser=userRepository.findItemByUserName(studentUserName);
        if(studentUser.isEmpty()) return "Enter valid username to delete";
//        userRepository.deleteByUserName(studentUserName);
        userRepository.deleteByUserName(studentUserName);
//        String studentId=userRepository.findByUserName(studentUserName);
//        userRepository.deleteById(studentId);
        return "Successfully deleted";
    }
    public String showUser(String teacherUserName, String teacherPassword, String studentUserName){
        Optional<User> teacherUser=userRepository.findItemByUserName(teacherUserName);
        if(teacherUser.isEmpty()) return "Please enter valid username";
        if(teacherUser.get().isTeacher()==false) return "Should be a teacher to view";
        String givenPassword=teacherUser.get().getPassword();
        if(!givenPassword.equals(teacherPassword)) return "Please enter valid password";
        Optional<User> studentUser=userRepository.findItemByUserName(studentUserName);
        if(studentUser.isEmpty()) return "Enter valid username to show";
        return studentUser.get().toString();
    }

    public String updateUserName(String teacherUserName, String teacherPassword, String studentUserName, String newStudentUserName) {
        Optional<User> teacherUser=userRepository.findItemByUserName(teacherUserName);
        if(teacherUser.isEmpty()) return "Please enter valid username";
        if(teacherUser.get().isTeacher()==false) return "Should be a teacher to view";
        String givenPassword=teacherUser.get().getPassword();
        if(!givenPassword.equals(teacherPassword)) return "Please enter valid password";
        Optional<User> studentUser=userRepository.findItemByUserName(studentUserName);
        if(studentUser.isEmpty()) return "Enter valid username to update";
        studentUser.get().setUserName(newStudentUserName);
        User savedPlayer= (User) userRepository.save(studentUser.get());
        return savedPlayer.toString();
    }
}
