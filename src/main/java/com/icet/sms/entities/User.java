package com.icet.sms.entities;

import com.icet.sms.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
