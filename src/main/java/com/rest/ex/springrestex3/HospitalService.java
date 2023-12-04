package com.rest.ex.springrestex3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    List<Hospital> hospitalList = new ArrayList<Hospital>(List.of(new Hospital(101, "AIIMS", "Delhi", 5.0),
            new Hospital(102, "PMCH", "Bihar", 3.0),new Hospital(105, "KIMS", "Bihar", 4.0), new Hospital(103, "KMCH", "Kerla", 3.5)));

    public List<Hospital> getHospitalLists() {
        return hospitalList;
    }

    public boolean removeHospitalById(int id) {
        Hospital hospital2 = hospitalList.stream().filter(hospital -> hospital.getId() == id).findFirst().get();
        return hospitalList.remove(hospital2);
    }

    public boolean deleteByLocationAndRating(String location, double rating) {
        List<Hospital> hospital3 = hospitalList.stream()
                .filter(hospital -> hospital.getLocation().equals(location) && hospital.getRating() < rating)
                .collect(Collectors.toList());
        return hospitalList.removeAll(hospital3);
    }

}
