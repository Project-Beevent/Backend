package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long id;
    private String city;
    private String state;
    private String district;

    public LocationDto(Location location) {
        BeanUtils.copyProperties(location, this);//avoiding the need to manually set each property
    }
}
