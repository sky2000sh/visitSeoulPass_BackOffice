package com.visitSeoulPass.backoffice.admin.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CodeVO {
    private String code;
    private String name;
    private String type;
    private String description;
    private Integer sortOrder;
    private Boolean isActive;
}
