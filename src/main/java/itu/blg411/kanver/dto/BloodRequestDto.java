package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.BloodRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestDto {
    private Long id;
    private Long locationId;
    private String name;
    private String phone;

    public BloodRequestDto(BloodRequest bloodRequest) {
        BeanUtils.copyProperties(bloodRequest, this);
    }
}
