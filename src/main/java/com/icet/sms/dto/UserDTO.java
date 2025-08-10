package com.icet.sms.dto;

import com.icet.sms.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
