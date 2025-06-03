package com.security.security.controller;


import com.security.security.DTO.Register;
import com.security.security.DTO.UpdateDTO;
import com.security.security.model.User;
import com.security.security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Register register) {
        return userService.register(register);
    }

    @GetMapping("/user")
    public  ResponseEntity<List<User>> getUserdetails(){
        return  ResponseEntity.ok(userService.getdetails());
    }

    @GetMapping("user/{id}")
    public  ResponseEntity<?>getuserbyid(@PathVariable Long id){
        return  ResponseEntity.ok(userService.getuserbyid(id));
    }


    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateDTO updateDTO) {
        return  userService.updateUser(id, updateDTO);
    }

}
