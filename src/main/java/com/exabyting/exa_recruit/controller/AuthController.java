package com.exabyting.exa_recruit.controller;

import com.exabyting.exa_recruit.dto.RefreshDto;
import com.exabyting.exa_recruit.dto.UserDto;
import com.exabyting.exa_recruit.enums.UserRole;
import com.exabyting.exa_recruit.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getLogin(@RequestBody UserDto userDto) {
        return authenticationService.login(userDto);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> getJwtToken(@RequestBody RefreshDto refreshDto) {
        return authenticationService.refresh(refreshDto.getRefreshToken());
    }

    @PostMapping("/register")
    public ResponseEntity<?> postRegister(@RequestBody UserDto userDto) {
        return authenticationService.register(userDto, UserRole.USER);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<?> postAdminRegister(@RequestBody UserDto userDto) {
        return authenticationService.register(userDto, UserRole.ADMIN);
    }
}
