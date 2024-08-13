package com.jyoticodes.springbootdemo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jyoticodes.springbootdemo.Entity.User;
import com.jyoticodes.springbootdemo.Repository.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> getAllUser()
    {
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(ObjectId Id)
    {
        return userRepository.findById(Id);
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public void deleteUser()
    {
        userRepository.deleteAll();
    }

    public void detelteById(ObjectId Id)
    {
        userRepository.deleteById(Id);
    }


    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


}
