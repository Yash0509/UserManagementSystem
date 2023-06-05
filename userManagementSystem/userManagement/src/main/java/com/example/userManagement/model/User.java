package com.example.userManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity(name = "user")
public class User {
    @Id
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

    @Column(name="fName")
    private String fName;

    @Column(name="lName")
    private String lName;

    @Column(name="emailId")
    private String emailId;

    @Column(name="rollNumber")
    private int rollNumber;

    @Column(name="hostel")
    private String hostel;

    @Column(name="roomNumber")
    private int roomNumber;

    @Column(name="passYear")
    private int passYear;

    @Column(name="isTeacher")
    private boolean isTeacher;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", rollNumber=" + rollNumber +
                ", hostel='" + hostel + '\'' +
                ", roomNumber=" + roomNumber +
                ", passYear=" + passYear +
                ", isTeacher=" + isTeacher +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPassYear() {
        return passYear;
    }

    public void setPassYear(int passYear) {
        this.passYear = passYear;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
