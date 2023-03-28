package com.example.hospital_management_system;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/patient")
public class PatientController {
    HashMap<Integer, Patient> patientDB = new HashMap<>();

    @PostMapping("/addViaParameters")
    public String addPatient(@RequestParam("patientID")Integer patientID, @RequestParam("name")String name, @RequestParam("age")Integer age, @RequestParam("disease")String disease) {

        Patient patient = new Patient(patientID, name, disease, age);
        patientDB.put(patientID, patient);
        return "Patient added successfully";
    }

    @PostMapping("/addViaReqBody")
    public String addPatient(@RequestBody Patient patient) {
        int key = patient.getPatientID();
        patientDB.put(key, patient);
        return "Patient added via request body";
    }

    @GetMapping("/getInfoViaPathVariable/{patientID}")
    public Patient getPatient(@PathVariable("patientID")Integer patientID) {
        Patient patient = patientDB.get(patientID);
        return patient;
    }

    @GetMapping("/getPatientsWithAgeAndDisease/{age}/{disease}")
    public List<Patient> getPatientsWithAgeDisease(@PathVariable("age")Integer age, @PathVariable("disease")String disease) {
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDB.values()) {
            if(p.getAge() > age && p.getDisease().equals(disease)) {
                patients.add(p);
            }
        }
        return patients;
    }

    @GetMapping("/getInfo")
    public Patient getPatientInfo(@RequestParam("patientID")Integer patientID) {
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

    @GetMapping("/getByName")
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

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientID")Integer patientID, @RequestParam("disease")String disease) {
        if(patientDB.containsKey(patientID)) {
            Patient patient = patientDB.get(patientID);
            patient.setDisease(disease);
            patientDB.put(patientID, patient);
            return "Updated successfully";
        }
        return "Patient does not exist";
    }

    @PutMapping("/updateDetails")
    public String updatePatientDetails(@RequestBody Patient patient) {
        int key = patient.getPatientID();
        if(patientDB.containsKey(key)) {
            patientDB.put(key, patient);
            return "Update patient successfully";
        }

        return "Data was not existing";
    }

    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientID")Integer patientID) {
        patientDB.remove(patientID);
        return "Patient deleted successfully";
    }

}
