package itu.blg411.kanver.dto;


import itu.blg411.kanver.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private Long id;
    private Long userId;
    private Long hospitalId;

    public NotificationDto(Notification notification) {
        BeanUtils.copyProperties(notification, this, "user", "hospital");

        if (notification.getUser() != null) {
            this.userId = notification.getUser().getId();
        }

        if (notification.getHospital() != null) {
            this.hospitalId = notification.getHospital().getId();
        }
    }


}
