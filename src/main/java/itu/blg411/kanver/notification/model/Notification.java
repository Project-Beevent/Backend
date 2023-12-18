package itu.blg411.kanver.notification.model;

import itu.blg411.kanver.hospital.model.Hospital;
import itu.blg411.kanver.user.model.User;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
