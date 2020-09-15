package com.hpstudio.gateway.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author mawen
 * @date 2020/9/9 10:19
 * @email 455766076@qq.com
 */
@Data
public class User {
    @Id
    private Integer id;

    private String userName;

    private String password;

    private int sex;
}
