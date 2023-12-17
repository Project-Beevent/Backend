package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.BloodRequest;
import itu.blg411.kanver.entity.Notification;
import itu.blg411.kanver.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private String bloodType;
    private String tcNo;
    private int age;
    private List<BloodRequestDto> bloodRequests = new ArrayList<>();
    private List<NotificationDto> notifications = new ArrayList<>();

    public UserDto(User user) {
        BeanUtils.copyProperties(user, this, "bloodRequests", "notifications");

        List<BloodRequest> bloodRequests = user.getBloodRequests();
        if (bloodRequests != null && !bloodRequests.isEmpty()) {
            bloodRequests.forEach(bloodRequest -> {
                BloodRequestDto bloodRequestDto = new BloodRequestDto(bloodRequest);
                this.bloodRequests.add(bloodRequestDto);
            });
        }

        List<Notification> notifications = user.getNotifications();
        if (notifications != null && !notifications.isEmpty()) {
            notifications.forEach(notification -> {
                NotificationDto notificationDto = new NotificationDto(notification);
                this.notifications.add(notificationDto);
            });
        }
    }


}
