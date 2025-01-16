package com.visitSeoulPass.backoffice.admin.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseParams {
    private Integer page = 1;
    private Integer size = 10;
    private String searchKeyword;
    private String searchType;
    private SortVO sort;
}
