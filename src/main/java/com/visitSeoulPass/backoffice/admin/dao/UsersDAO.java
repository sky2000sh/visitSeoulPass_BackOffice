package com.visitSeoulPass.backoffice.admin.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter @Setter @ToString
@NoArgsConstructor
public class UsersDAO {
    private String id;
    private String username;
    private String email;
    private String name;
    private String phone;
    private String role;
    private String status;
    private String[] ids;
    private String auth;
}
