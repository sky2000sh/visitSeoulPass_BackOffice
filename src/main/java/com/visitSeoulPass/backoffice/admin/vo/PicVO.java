package com.visitSeoulPass.backoffice.admin.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PicVO extends CommonVO {

	private String picUid;
	private String partnerUid;
    private String partnerNm;
	private String authrtGradeCd;
	private String operatorYn;
	private String mngrYn;
	private String picNm;
	private String jbgdNm;
	private String deptNm;
	private String contact;
	private String activeYn;
	private String delYn;
	private String menuList;
	private String pswd;
	private String id;
	private String eml;
	private String telno;
	private String flag;
	private String auhrtGradeCdNm;
	private String mbrUid;
	private String chgpswd;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date crtDt;
	private String creater;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date mdfcnDt;
	private String mdfr;
	private int pswdFailTimes; //비번오류횟수

}
