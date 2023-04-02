package com.example.hospital_management_system.models;

public class Doctor {
    private int doctorID;
    private String name;
    private String specialization;
    private int age;
    private String degree;

    public Doctor(int doctorID, String name, String specialization, int age, String degree) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.age = age;
        this.degree = degree;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
