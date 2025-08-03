package com.icet.sms.repository;

import com.icet.sms.entities.User;
import com.icet.sms.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserRole(UserRole userRole);
}
