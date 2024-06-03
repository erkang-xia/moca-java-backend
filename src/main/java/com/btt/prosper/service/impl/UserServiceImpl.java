package com.btt.prosper.service.impl;

import com.btt.prosper.common.constant.MessageConstant;
import com.btt.prosper.common.constant.StatusConstant;
import com.btt.prosper.common.exception.AccountLockedException;
import com.btt.prosper.common.exception.AccountNotFoundException;
import com.btt.prosper.common.exception.PasswordErrorException;
import com.btt.prosper.entity.User;
import com.btt.prosper.mapper.UserMapper;
import com.btt.prosper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        //1、根据用户名查询数据库中的数据
        user = userMapper.getByUsername(username);


        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);

        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return user;
    }
}
