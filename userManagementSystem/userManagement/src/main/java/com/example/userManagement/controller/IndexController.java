package com.example.userManagement.controller;
import com.example.userManagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @Autowired
    LoginService loginService;
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST,value = "/create-user")
    public String createUser(@RequestParam("userName") String userName,@RequestParam("password") String password,@RequestParam("fName") String fName,@RequestParam("lName") String lName,@RequestParam("emailId") String emailId,@RequestParam("rollNumber") int rollNumber,@RequestParam("hostel") String hostel,@RequestParam("roomNumber") int roomNumber,@RequestParam("passYear") int passYear,@RequestParam("isTeacher") boolean isTeacher ){
        return loginService.saveNewUser(userName,password,fName,lName,emailId,rollNumber,hostel,roomNumber,passYear,isTeacher);
    }
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST,value = "/delete-user")
    public String deleteUser(@RequestParam("teacherUserName") String teacherUserName,@RequestParam("teacherPassword") String teacherPassword,@RequestParam("studentUserName") String studentUserName){
        return loginService.deleteStudent(teacherUserName,teacherPassword,studentUserName);
    }
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST,value = "/show-user")
    public String showUser(@RequestParam("teacherUserName") String teacherUserName,@RequestParam("teacherPassword") String teacherPassword,@RequestParam("studentUserName") String studentUserName){
        return loginService.showUser(teacherUserName,teacherPassword,studentUserName);
    }
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST,value = "/update-username")
    public String updateUserName(@RequestParam("teacherUserName") String teacherUserName,@RequestParam("teacherPassword") String teacherPassword,@RequestParam("studentUserName") String studentUserName,@RequestParam("newStudentUserName") String newStudentUserName){
        return loginService.updateUserName(teacherUserName,teacherPassword,studentUserName,newStudentUserName);
    }

}
