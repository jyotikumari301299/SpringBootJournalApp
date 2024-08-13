package com.jyoticodes.springbootdemo.Services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
     @Autowired
    private UserService userService;

    @Test
    public void testUserService()
    {
        
        assertNotNull(userService.findByUserName("Ram"),"usename not present");
        assertEquals(3, 2+1, "2 + 1 should equal 3");
    }
}
