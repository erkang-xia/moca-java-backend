package com.btt.prosper.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    //姓名
    private String name;
    private String username;
    private String password;

    private Integer status;
    private Integer sex;
    private Integer age;
    private String phone;
    private String address;

    //头像
    private String avatar;

    //注册时间
    private LocalDateTime createTime;

}
