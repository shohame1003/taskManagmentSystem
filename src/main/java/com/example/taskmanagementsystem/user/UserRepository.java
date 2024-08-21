package com.example.taskmanagementsystem.user;

import com.example.taskmanagementsystem.common.repository.GenericSpecificationRepository;
import com.example.taskmanagementsystem.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericSpecificationRepository<User, Integer>
       {

    Optional<User> findUserByPhoneNumber(String phoneNumber);
}
