package com.example.hospital_management_system;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class PatientController {
    HashMap<Integer, Patient> patientDB = new HashMap<>();

    @PostMapping("/addPatientViaParameters")
    public String addPatient(@RequestParam("patientID")Integer patientID, @RequestParam("name")String name, @RequestParam("age")Integer age, @RequestParam("disease")String disease) {

        Patient patient = new Patient(patientID, name, disease, age);
        patientDB.put(patientID, patient);
        return "Patient added successfully";
    }

    @PostMapping("/addPatientViaReqBody")
    public String addPatient(@RequestBody Patient patient) {
        int key = patient.getPatientID();
        patientDB.put(key, patient);
        return "Patient added via request body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientID")Integer patientID) {
        Patient patient = patientDB.get(patientID);
        return patient;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDB.values()) {
            patients.add(p);
        }
        return patients;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientbyName(@RequestParam("name")String name) {
        for(Patient p : patientDB.values()) {
            if(p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @GetMapping("/getPatientsGreaterThanAge")
    public List<Patient> getPatientsGreaterThanAge(@RequestParam("age")Integer age) {
        List<Patient> filteredPatients = new ArrayList<>();
        for(Patient p : patientDB.values()) {
            if(p.getAge() > age) {
                filteredPatients.add(p);
            }
        }
        return filteredPatients;
    }

}
