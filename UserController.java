package com.example.Spring.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.Model.*;
import com.example.Spring.Repository.*;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/User/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        Optional<User>userData = userRepository.findById(id);

        if(userData.isPresent()){
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}

        @PostMapping("/Users")
        public ResponseEntity<User> createTutorial (@RequestBody User user) {
        try{
            User u = new User (user.getName(),user.getEmail(),user.getPhone(),user.getAddress() ,user.getPinCode(),user.getState() ,user.getPass());
            String ans = user.getEmail();
            
            User user2 = userRepository.save(u);
            return new ResponseEntity<>(user2, HttpStatus.CREATED);}
        catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);}
        }

    @PutMapping("/User1/{id}")
    public ResponseEntity<User> updateUser (@PathVariable("id") int id , @RequestBody User user){
        Optional<User>userData = userRepository.findById(id);
        if(userData.isPresent()){
            User user3 = userData.get();
            user3.setName(user.getName());
            user3.setEmail(user.getEmail());
            user3.setPhone(user.getPhone());
            user3.setAddress(user.getAddress());
            user3.setPinCode(user.getPinCode());
            user3.setState(user.getState());
            user3.setPass(user.getPass());
            
return new ResponseEntity<>(userRepository.save(user3),HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }
    @GetMapping("/Users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id){
        try{
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/Users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            userRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }

