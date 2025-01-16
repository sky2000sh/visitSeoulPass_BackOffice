package com.visitSeoulPass.backoffice.admin.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersParams extends BaseParams {
    private String role;
    private String status;
}
