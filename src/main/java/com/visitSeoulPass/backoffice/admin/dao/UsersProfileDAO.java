package com.visitSeoulPass.backoffice.admin.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsersProfileDAO {
    private String id;
    private String username;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String bio;
    private String avatarUrl;
    private String role;
    private String status;
    private String ntnCd;
    private String ntnTelno;
    private String languageCd;
    private String eventRcptnYn;
    private String creater;
    private String mdfr;
    private String bizTypeCode;
    private String pswd;
    private String engSurname;
    private String gender;
    private String brdt;
    private String code;
    private String phoneNumber;
    private String categoryCode;
    private String membershipGradeCode;
    private String state;
}
