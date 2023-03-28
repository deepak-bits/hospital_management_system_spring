package com.example.hospital_management_system;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    HashMap<Integer, Nurse> nurseDB = new HashMap<>();

    public String addNurse(Nurse nurse) {
        int key = nurse.getNurseID();
        nurseDB.put(key, nurse);
        return "Nurse added successfully";
    }

    public List<Nurse> getAllNurses() {
        return nurseDB.values().stream().toList();
    }

}
