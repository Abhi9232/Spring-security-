package com.security.security.service;

import com.security.security.DTO.Register;
import com.security.security.DTO.UpdateDTO;
import com.security.security.model.User;
import com.security.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public ResponseEntity<?> register(Register register) {

        if (register.getEmail() == null || register.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

         User  existuser=userRepository.findByEmail(register.getEmail());
         if (existuser!=null){
              return  ResponseEntity.status(HttpStatus.CONFLICT).body("Username already Exist");
         }
         User user=  new User();

         user.setFirstName(register.getFirstName());
         user.setLastName(register.getLastName());
         user.setEmail(register.getEmail());
         userRepository.save(user);

         return  ResponseEntity.ok().body("user is created");

    }

    public ResponseEntity<?> updateUser(Long id, UpdateDTO dto) {
        Optional <User> userOpt=this.userRepository.findById(id);

        if(userOpt.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        User  update= userOpt.get();

        if(dto.getFirstName()!=null)update.setFirstName(dto.getFirstName());
        if(dto.getLastName()!=null)update.setLastName(dto.getLastName());
        if (dto.getEmail()!=null)update.setEmail(dto.getEmail());

        userRepository.save(update);

        return ResponseEntity.ok().body("user updated succesfully");
    }

    public List<User> getdetails() {
         return  userRepository.findAll();


    }

    public Optional<User> getuserbyid(Long id) {
        return userRepository.findById(id);
    }
}
