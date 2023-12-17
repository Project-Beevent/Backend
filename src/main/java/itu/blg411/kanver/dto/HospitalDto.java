package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private Long id;
    private Long locationId;
    private String name;
    private String phone;
    private List<NotificationDto> notifications = new ArrayList<>();
    private List<BloodRequestDto> bloodRequests = new ArrayList<>();

    public HospitalDto(Hospital hospital) {
        BeanUtils.copyProperties(hospital, this, "location", "notifications", "bloodRequests");

    if (hospital.getLocation() != null) {
        this.locationId = hospital.getLocation().getId();
    }


    hospital.getNotifications().forEach(notification -> {
        NotificationDto notificationDto = new NotificationDto(notification);
        this.notifications.add(notificationDto);
    });

    hospital.getBloodRequests().forEach(bloodRequest -> {
        BloodRequestDto bloodRequestDto = new BloodRequestDto(bloodRequest);
        this.bloodRequests.add(bloodRequestDto);
    });







    }




}
