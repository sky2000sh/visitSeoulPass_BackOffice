package com.visitSeoulPass.backoffice.admin.vo;

import com.visitSeoulPass.backoffice.admin.params.BaseParams;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonVO {
    private Integer page = 1;
    private Integer size = 10;
    private String sortBy;
    private String sortOrder;
    private String keyword;
    private Long totalCount;
    private Integer totalPages;

    public CommonVO assignPagination(BaseParams params) {
        if (params != null) {
            this.page = params.getPage();
            this.size = params.getSize();
            this.sortBy = params.getSortBy();
            this.sortOrder = params.getSortOrder();
            this.keyword = params.getKeyword();
        }
        return this;
    }
}
