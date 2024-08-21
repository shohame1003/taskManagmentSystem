package com.example.taskmanagementsystem.user;

import com.example.taskmanagementsystem.common.exception.PhoneNumberNotVerifiedException;
import com.example.taskmanagementsystem.common.service.GenericCrudService;
import com.example.taskmanagementsystem.jwt.JwtService;
import com.example.taskmanagementsystem.user.dto.*;
import com.example.taskmanagementsystem.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Getter
public class UserService extends GenericCrudService<User, Integer, UserCreateDto,
        UserUpdateDto, UserPatchDto, UserResponseDto> implements UserDetailsService {

    private final UserRepository repository;
    private final UserMapperDto mapper;
    private final Class<User> EntityClass = User.class;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        return repository.findUserByPhoneNumber(phone)
                .orElseThrow(() -> new BadCredentialsException("bad credentials"));
    }


    @Override
    protected User save(UserCreateDto userCreateDto) {
        User entity = mapper.toEntity(userCreateDto);
        entity.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        return repository.save(entity);
    }

    @Override
    protected User updateEntity(UserUpdateDto userUpdateDto, User user) {
        mapper.update(userUpdateDto, user);
        return repository.save(user);
    }

    public UserSignInResponseDto signIn(UserSignInDto signInDto) {
        String phoneNumber = signInDto.getPhoneNumber();

        User user = repository.findUserByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new BadCredentialsException("Username or password doesn't match"));

        if (passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
            if (user.isPhoneNumberVerified()) {
                String token = jwtService.generateToken(user.getPhoneNumber());
                UserResponseDto responseDto = mapper.toResponseDto(user);
                return new UserSignInResponseDto(responseDto, token);
            }
            throw new PhoneNumberNotVerifiedException("%s is not verified. Please verify phone your phone number".formatted(user.getPhoneNumber()));
        }
        throw new BadCredentialsException("Username or password doesn't match");
    }
}
