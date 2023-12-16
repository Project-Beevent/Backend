package itu.blg411.kanver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity//for hibernate
@Table(name = "locations")//for table of our db
@Data// A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields and @RequiredArgsConstructor.
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String state;
    private String district;
}
