package com.exabyting.exa_recruit.controller;

import com.exabyting.exa_recruit.dto.exarecruitdb.RefreshDTO;
import com.exabyting.exa_recruit.dto.exarecruitdb.UserDTO;
import com.exabyting.exa_recruit.constant.enums.UserRole;
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
    public ResponseEntity<?> getLogin(@RequestBody UserDTO userDto) {
        return authenticationService.login(userDto);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> getJwtToken(@RequestBody RefreshDTO refreshDto) {
        return authenticationService.refresh(refreshDto.getRefreshToken());
    }

    @PostMapping("/register")
    public ResponseEntity<?> postRegister(@RequestBody UserDTO userDto) {
        return authenticationService.register(userDto, UserRole.USER);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<?> postAdminRegister(@RequestBody UserDTO userDto) {
        return authenticationService.register(userDto, UserRole.ADMIN);
    }
}
