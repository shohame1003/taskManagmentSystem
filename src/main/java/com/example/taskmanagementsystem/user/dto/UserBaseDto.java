package com.example.taskmanagementsystem.user.dto;

import com.example.taskmanagementsystem.user.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBaseDto {

    @NotBlank(message = "auth.user.name.required")
    private String name;
    @Email
    private String email;

    private String phoneNumber;

    private List<Role> roles;



}
