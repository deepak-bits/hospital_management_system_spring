package com.example.hospital_management_system.controllers;

import com.example.hospital_management_system.models.Nurse;
import com.example.hospital_management_system.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
//    NurseService nurseService = new NurseService();
    @Autowired
    NurseService nurseService;

    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse) {
        String ans = nurseService.addNurse(nurse);
        return ans;
    }

    @GetMapping("/getByAge")
    public List<Nurse> getNursesGreaterThanAge(@RequestParam("age")Integer age) {
        List<Nurse> nurseList = nurseService.getList(age);
        return nurseList;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNursesbyQualification(@RequestParam("qualificaiton")String qualification) {
        List<Nurse> nurseList = nurseService.getNursesWithQualification(qualification);
        return nurseList;
    }
}
