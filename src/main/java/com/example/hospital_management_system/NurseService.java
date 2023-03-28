package com.example.hospital_management_system;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse) {
        // we can write some logic / validations
        if(nurse.getNurseID() < 0) {
            return "Enter a valid nurseID";
        }

        if(nurse.getName() == null) {
            return "Name should not be null";
        }

        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getList(int age) {
        List<Nurse> nurseList = nurseRepository.getAllNurses();
        List<Nurse> filteredNurses = new ArrayList<>();

        for(Nurse nurse : nurseList) {
            if(nurse.getAge() > age) {
                filteredNurses.add(nurse);
            }
        }
        return filteredNurses;
    }

    public List<Nurse> getNursesWithQualification(String qualification) {
        List<Nurse> nurseList = nurseRepository.getAllNurses();
        List<Nurse> filteredNurses = new ArrayList<>();

        // Logic to filter based on qualification

        for(Nurse nurse : nurseList) {
            if(nurse.getQualification().equals(qualification)) {
                filteredNurses.add(nurse);
            }
        }
        return filteredNurses;
    }
}
