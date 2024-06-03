package com.btt.prosper;

import com.btt.prosper.entity.User;
import com.btt.prosper.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProsperApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        List<User> users = userMapper.list();
        System.out.println(users);

    }

}
