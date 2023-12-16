package itu.blg411.kanver.dto;

import itu.blg411.kanver.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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

    public UserDto(User user) {
        BeanUtils.copyProperties(user, this);
    }
}
