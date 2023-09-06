package ru.ruba.Cinema_Project.controller;

import ru.ruba.Cinema_Project.dto.request.UserRequestDto;
import ru.ruba.Cinema_Project.dto.response.UserResponseDto;
import ru.ruba.Cinema_Project.model.User;
import ru.ruba.Cinema_Project.service.AuthenticationService;
import ru.ruba.Cinema_Project.service.mapper.ResponseDtoMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authService,
                                    ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userDtoResponseMapper.mapToDto(user);
    }
}