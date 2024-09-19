package com.accumenta.User_Service.controller;

import com.accumenta.User_Service.dto.ResponceWapper;
import com.accumenta.User_Service.model.User;
import com.accumenta.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/adduser")
    public ResponseEntity<ResponceWapper> addUser(@RequestBody User user){
        User dbUser = this.userService.addUser(user);
       return ResponseEntity.status(HttpStatus.OK).body(new ResponceWapper<>(dbUser));
    }

    @GetMapping("/api/getuser/{userId}")
    public ResponseEntity<ResponceWapper> getUser(@PathVariable long userId){
        User dbUser = this.userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponceWapper<>(dbUser));
    }

    @PutMapping("/api/update/{userId}")
    public ResponseEntity<ResponceWapper> updateUser(@RequestBody User user,@PathVariable long userId){
        User dbUser = this.userService.updateUser(user,userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponceWapper<>(dbUser));
    }
    @DeleteMapping("/api/deluser/{userId}")
    public ResponseEntity<ResponceWapper> deleteUser(@PathVariable long userId){
       boolean dbUser= this.userService.deleteUser(userId);
       return ResponseEntity.status(HttpStatus.OK).body(new ResponceWapper<>(dbUser));
    }
}
