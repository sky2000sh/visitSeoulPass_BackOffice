package com.visitSeoulPass.backoffice.admin.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsersParams extends BaseParams {
    private String uid;
    private String[] type;
    private String[] grade;
    private String[] state;
    private String[] status;
    private String search;
    private String periodType;
    private String fromDate;
    private String toDate;
    private String userEml;
}
