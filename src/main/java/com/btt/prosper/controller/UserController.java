package com.btt.prosper.controller;

import com.btt.prosper.common.constant.JwtClaimsConstant;
import com.btt.prosper.common.exception.LoginFailedException;
import com.btt.prosper.common.properties.JwtProperties;
import com.btt.prosper.common.result.Result;
import com.btt.prosper.common.utils.JwtUtil;
import com.btt.prosper.common.vo.UserVO;
import com.btt.prosper.entity.User;
import com.btt.prosper.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<UserVO> userLogin(@RequestBody User user) throws LoginFailedException {
        log.info("用户登入:{}", user);
        user = userService.login(user);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        UserVO userVO = UserVO.builder()
                .id(user.getId())
                .name(user.getName())
                .token(token)
                .build();
        return Result.success(userVO);
    }


    @GetMapping("/test")
    public Result userLogin()  {
        log.info("test running");

        return Result.success("you did it");
    }




}
