package com.SWprj.SWprj.User;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.*;

@Data
@Entity
@Table(name = "user")
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