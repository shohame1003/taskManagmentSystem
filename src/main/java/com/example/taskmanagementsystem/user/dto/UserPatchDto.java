package com.example.taskmanagementsystem.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPatchDto {
    private String name;
    private String email;
    private String password;
}
