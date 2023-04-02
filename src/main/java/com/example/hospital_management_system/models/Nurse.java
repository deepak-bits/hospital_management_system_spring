package com.example.hospital_management_system.models;

public class Nurse {
    private int nurseID;
    private String name;
    private int age;
    private String qualification;

    public Nurse(int nurseID, String name, int age, String qualification) {
        this.nurseID = nurseID;
        this.name = name;
        this.age = age;
        this.qualification = qualification;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
