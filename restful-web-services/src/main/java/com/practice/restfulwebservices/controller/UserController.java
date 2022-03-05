package com.practice.restfulwebservices.controller;

import com.practice.restfulwebservices.User.User;
import com.practice.restfulwebservices.dao.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserDaoService service;

    //get all user
    @GetMapping("/user")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //get user
    @GetMapping("/user/{id}")
    public User retrieveOneUser(@PathVariable UUID id){
        User user= service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    //post
    @PostMapping("/user")
    public ResponseEntity<Object> CreateUser(@Valid @RequestBody User user){
        user.setId(UUID.randomUUID());
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable UUID id){
        User user= service.deleteById(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }
}
