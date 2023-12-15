package com.SWprj.SWprj.Hospital;

import com.SWprj.SWprj.Location.Location;
import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private String name;
    private String phone;
}
