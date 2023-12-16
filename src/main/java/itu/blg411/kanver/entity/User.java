package itu.blg411.kanver.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String bloodType;
    private String tcNo;
    private int age;
    private LocalDate lastDonationDate;
    private int donationCount;
}