package com.icet.sms.service;

import com.icet.sms.dto.UserDTO;
import com.icet.sms.entities.User;
import com.icet.sms.enums.UserRole;
import com.icet.sms.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.icet.sms.enums.UserRole.ADMIN;

@RequiredArgsConstructor
@Service
public class AuthService {

    final UserRepository userRepository;

    @PostConstruct
    private void createAdmin(){
        User optionalUser = userRepository.findByUserRole(UserRole.ADMIN);

        if (optionalUser==null){
            User user = new User();
            user.setName("Nimantha");
            user.setUserRole(ADMIN);
            user.setEmail("admin@gmail.com");
            user.setPassword("1234");

            userRepository.save(user);
            System.out.println("Admin Created");
        }else{
            System.out.println("Admin not Created");
        }
    }

    public Optional<User> login(UserDTO userDTO){
        Optional<User> userByEmail = userRepository.findByEmail(userDTO.getEmail());

        if (userByEmail.isPresent() && userByEmail.get().getPassword().equals(userDTO.getPassword())){
            return userByEmail;
        }
        return null;
    }
}
