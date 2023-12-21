package itu.blg411.kanver.hospital.controller;

import itu.blg411.kanver.hospital.HospitalService;
import itu.blg411.kanver.hospital.model.Hospital;
import itu.blg411.kanver.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return ResponseEntity.status(HttpStatus.OK).body(hospitals);
    }
    @GetMapping("/{cityName}")
    public ResponseEntity<List<Hospital>> getHospitalsByCity(@PathVariable String cityName) {
        List<Hospital> hospitals = locationService.getHospitalsByCity(cityName);
        return ResponseEntity.status(HttpStatus.OK).body(hospitals);
    }
}