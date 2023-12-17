package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.Hospital;
import itu.blg411.kanver.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long id;
    private String city;
    private String state;
    private String district;
    private List<HospitalDto> hospitals = new ArrayList<>();

    public LocationDto(Location location) {
        BeanUtils.copyProperties(location, this, "hospitals");

        List<Hospital> hospitals = location.getHospitals();
        if (hospitals != null && !hospitals.isEmpty()) {
            hospitals.forEach(hospital -> {
                HospitalDto hospitalDto = new HospitalDto(hospital);
                this.hospitals.add(hospitalDto);
            });
        }
    }
}
