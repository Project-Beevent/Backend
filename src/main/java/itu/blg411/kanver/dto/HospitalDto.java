package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private Long id;
    private Long locationId;
    private String name;
    private String phone;

    public HospitalDto(Hospital hospital) {
        BeanUtils.copyProperties(hospital, this);
    }
}
