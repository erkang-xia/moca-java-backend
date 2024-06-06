package com.btt.prosper.service;

import com.btt.prosper.common.dto.UserLoginDTO;
import com.btt.prosper.entity.User;

public interface UserService {

    User login(UserLoginDTO userLoginDTO);
}
