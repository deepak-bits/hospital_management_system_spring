package com.example.hospital_management_system.controllers;

import com.example.hospital_management_system.models.Doctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    HashMap<Integer, Doctor> doctorDB = new HashMap<>();

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor) {
        int key = doctor.getDoctorID();
        doctorDB.put(key, doctor);
        return "Doctor added successfully";
    }
}
