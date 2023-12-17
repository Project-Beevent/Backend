package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.BloodRequest;
import itu.blg411.kanver.entity.Hospital;
import itu.blg411.kanver.entity.Notification;
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
        BeanUtils.copyProperties(hospital, this, "locationId", "notifications", "bloodRequests");

    if (hospital.getLocation() != null) {
        this.locationId = hospital.getLocation().getId();
    }


    List<Notification> notifications = hospital.getNotifications();
    if (notifications != null && !notifications.isEmpty()) {
        notifications.forEach(notification -> {
            NotificationDto notificationDto = new NotificationDto(notification);
            this.notifications.add(notificationDto);
        });
    }

        List<BloodRequest> bloodRequests = hospital.getBloodRequests();
        if (bloodRequests != null && !bloodRequests.isEmpty()) {
            bloodRequests.forEach(bloodRequest -> {
                BloodRequestDto bloodRequestDto = new BloodRequestDto(bloodRequest);
                this.bloodRequests.add(bloodRequestDto);
            });
        }







    }




}
