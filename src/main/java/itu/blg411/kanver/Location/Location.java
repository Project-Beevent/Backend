package com.SWprj.SWprj.Location;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String city;
    private String state;
    private String district;
}
