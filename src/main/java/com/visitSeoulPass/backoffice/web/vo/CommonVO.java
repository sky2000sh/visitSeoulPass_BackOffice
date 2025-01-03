package com.visitSeoulPass.backoffice.web.vo;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

// import com.kcp.api.common.APIConst;
// import com.kcp.api.common.APIValidator;
// import com.kcp.api.params.BaseParams;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonVO {

	private static final long serialVersionUID = 1L;

	protected int currentPage;
	protected int pageSize;
	protected int startPageNo;
	protected int startNo;

	private int no;
	private String userId;
	private String fromDate;
	private String toDate;
	private String userLang;  /* 사용자 선택언어 */
	private MultipartFile file;
	private List<MultipartFile> fileList;
	private List<SortVO> sorting;


    // protected CommonVO assignPagination(BaseParams params) {
    //     if (params != null) {
    //         this.pageSize = BaseParams.toInt(params.getPageSize(), APIConst.MAX_ITEMS_COUNT);

    //         if (APIValidator.isValid(params.getStartPageNo()))
    //             this.startPageNo = Integer.parseInt(params.getStartPageNo());

    //         if (APIValidator.isValid(params.getCurrentPage()))
    //             this.currentPage = Integer.parseInt(params.getCurrentPage());

    //         this.startNo = ((this.pageSize > 0) && (this.currentPage > 0)) ?
    //             Math.max((this.currentPage - 1) * this.pageSize, 0) : 0;
    //     }

    //     return this;
    // }

    // protected CommonVO assignPagination(CommonVO params) {

    //     if (params != null) {
    //         this.pageSize = params.getPageSize() != 0 ? params.getPageSize() : APIConst.MAX_ITEMS_COUNT;
    //         this.startPageNo = params.getStartPageNo();
    //         this.currentPage = params.getCurrentPage();
    //         this.startNo = ((this.pageSize > 0) && (this.currentPage > 0)) ?
    //             Math.max((this.currentPage - 1) * this.pageSize, 0) : 0;
    //     }

    //     return this;
    // }
    

}
