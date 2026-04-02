package com.Sachin.CustomerManagement.Controller;

import com.Sachin.CustomerManagement.Dto.loginDto;
import com.Sachin.CustomerManagement.Jwt.JwtUtils;
import com.Sachin.CustomerManagement.Service.User.UserService;
import com.Sachin.CustomerManagement.VO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class authController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String test() {
        return "Testing.....";
    }

    // signup
    @PostMapping("/signup")
    public void singup(@RequestBody User user) {
        userService.saved(user);
    }

    //login

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody loginDto request) {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
            String jwt = jwtUtils.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(jwt);

        } catch (AuthenticationException e) {


            log.error("Exception Occurs while creating jwt token" + e);
            return new ResponseEntity<>("Incorrect Username and password", HttpStatus.UNAUTHORIZED);
        }


    }

}
