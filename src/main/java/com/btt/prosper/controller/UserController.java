package com.btt.prosper.controller.user;

import com.btt.prosper.common.constant.JwtClaimsConstant;
import com.btt.prosper.common.exception.LoginFailedException;
import com.btt.prosper.common.properties.JwtProperties;
import com.btt.prosper.common.result.Result;
import com.btt.prosper.common.utils.JwtUtil;
import com.btt.prosper.common.vo.UserVO;
import com.btt.prosper.entity.User;
import com.btt.prosper.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
//@Api(tags = "用户相关接口")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
//    @ApiOperation("login 用户登入")
    public Result<UserVO> userLogin(@RequestBody User user) throws LoginFailedException {
        log.info("员工登入:{}", user);
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


}
