package com.exabyting.exa_recruit.service;

import com.exabyting.exa_recruit.dto.exarecruitdb.ResponseDTO;
import com.exabyting.exa_recruit.dto.exarecruitdb.UserDTO;
import com.exabyting.exa_recruit.entity.exarecruitdb.User;
import com.exabyting.exa_recruit.constant.enums.UserRole;
import com.exabyting.exa_recruit.repository.exarecruitdb.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;

    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                                 JwtService jwtService, AuthenticationManager authenticationManager,
                                 RefreshTokenService refreshTokenService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
    }

    public boolean invalidUserDto(UserDTO userDto) {
        if(userDto.getUsername() == null || userDto.getUsername().isEmpty()) return true;
        if(userDto.getPassword() == null || userDto.getPassword().isEmpty()) return true;
        return false;
    }

    public ResponseEntity<?> register(UserDTO userDto, UserRole role) {
        Map<String, Object> response = new HashMap<>();

        if (invalidUserDto(userDto)) {
            response.put("message", "Please provide both username and password.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(role);

        try {
            userRepository.save(user);
        } catch (Exception e) {
            response.put("message", "Username already exists.");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        response.put("message", String.format("%s registered successfully.", role.name()));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<?> login(UserDTO userDto) {
        Map<String, Object> response = new HashMap<>();

        if (invalidUserDto(userDto)){
            response.put("message", "Please provide both username and password.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null){
            response.put("message", "User not found.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDto.getUsername(), userDto.getPassword());
            authenticationManager.authenticate(authToken);
        } catch (Exception e) {
            response.put("message", "Invalid password.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        String jwtToken = jwtService.generateToken(user);
        String refreshToken = refreshTokenService.generateRefreshToken(user.getUsername());

        ResponseDTO responseDto = new ResponseDTO(jwtToken, refreshToken, user.getRole());
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    public ResponseEntity<?> refresh(String token) {
        Map<String, Object> response = new HashMap<>();

        if (refreshTokenService.isValid(token)) {
            String jwtToken = refreshTokenService.getJwtToken(token);
            response.put("jwt", jwtToken);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        response.put("message", "Refresh token invalid or expired.");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
