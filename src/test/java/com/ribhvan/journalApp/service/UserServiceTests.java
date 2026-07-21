package com.ribhvan.journalApp.service;

import com.ribhvan.journalApp.entity.User;
import com.ribhvan.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

@Autowired
private UserRepository userRepository;
@Autowired
private UserService userService;

    @Disabled
    @ParameterizedTest
    @ValueSource(strings={
            "ABC","ABC1","ABC2"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name), "failed for: " + name);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
        "1,2,3", "3,3,3", "2,3,5"
    })
    public void test(int a,int b, int expected){
        assertEquals(expected, a+b);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){  //test for saveNewUser
        assertTrue(userService.saveNewUser(user));
    }
}
