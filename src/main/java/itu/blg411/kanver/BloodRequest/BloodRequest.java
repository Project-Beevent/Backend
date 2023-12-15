package com.SWprj.SWprj.BloodRequest;

import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.*;

@Data
@Entity
@Table(name = "blood_request")
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private String bloodType;
    private String status;
    private LocalDate dateRequested;
    private String title;
    private String description;
}