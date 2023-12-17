package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.BloodRequest;
import itu.blg411.kanver.entity.Hospital;
import itu.blg411.kanver.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestDto {
    private Long id;
    private Long userId;
    private Long hospitalId;
    private String bloodType;
    private String status;
    private LocalDate dateRequested;
    private String title;
    private String description;

    public BloodRequestDto(BloodRequest bloodRequest) {
        BeanUtils.copyProperties(bloodRequest, this, "userId", "hospitalId");

        if (bloodRequest.getUser() != null) {
            this.userId = bloodRequest.getUser().getId();
        }

        if (bloodRequest.getHospital() != null) {
            this.hospitalId = bloodRequest.getHospital().getId();
        }
    }


}
