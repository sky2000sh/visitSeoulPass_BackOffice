package com.visitSeoulPass.backoffice.admin.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter @Setter @ToString
@NoArgsConstructor
public class CertEmailReqDAO {
    private String email;
    private String code;
    private String type;
    private Long expiresIn;
    private String status;
}
