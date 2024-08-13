package com.jyoticodes.springbootdemo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyoticodes.springbootdemo.Entity.User;
import com.jyoticodes.springbootdemo.Services.UserService;



@RestController
@RequestMapping("User")
public class UserController {
    
    @Autowired
    private UserService userService;
    // @Autowired
    // private QuotesApiService quotesApiService;

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user)
    {
          userService.saveUser(user);
    }

    @GetMapping("/getAllUser")
    public ArrayList<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @PutMapping("/updateUser/{userName}")
     public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userName") String userName)
    {
        System.out.println("*********************I am here*********************");
        User userInDb = userService.findByUserName(userName);
        // User userInDb = userService.findByUserName(user.getUserName());
        System.out.println("*********************"+userInDb.toString()+"**********************");
        if(userInDb != null)
        {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveUser(userInDb);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    // Getting external API call
    // @GetMapping("/greetings/{userName}")
    // public ResponseEntity<?> greetings(@PathVariable String userName)
    // {
    //     QuotesResponse body = quotesApiService.getQuotes();
    //     return new ResponseEntity<>("Hi "+ userName + body,HttpStatus.OK);
    // }
}
