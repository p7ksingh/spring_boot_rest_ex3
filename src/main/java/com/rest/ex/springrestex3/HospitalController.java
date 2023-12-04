package com.rest.ex.springrestex3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/hospitals")
    public List<Hospital> getHospital() {

        return hospitalService.getHospitalLists();
    }

    @DeleteMapping("/hospitals/{id}")
    public String deleteHospitalById(@PathVariable int id) {
        return hospitalService.removeHospitalById(id) ? "success" : "error";
    }

    @DeleteMapping("/hospitals/{location}/{rating}")
    public String deleteHospitalById(@PathVariable String location, @PathVariable double rating) {
        return hospitalService.deleteByLocationAndRating(location, rating) ? "success" : "error";
    }
}
