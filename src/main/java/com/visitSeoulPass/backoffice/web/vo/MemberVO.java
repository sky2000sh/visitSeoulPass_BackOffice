package com.visitSeoulPass.backoffice.web.vo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
// import com.kcp.api.dto.users.UsersDTO;
// import com.kcp.api.dto.users.UsersProfileDTO;
// import com.kcp.api.params.BaseParams;
// import com.kcp.api.params.UsersParams;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(description =  "MemberVo")
public class MemberVO extends CommonVO {

	private static final long serialVersionUID = 1L;
//	@ApiModelProperty(required = true, value = "NM0000000001", example = "NM0000000001")
	private String mbrUid;
	private String id;
	private String eml;
//	@ApiModelProperty(required = true, value = "이름", example = "이름")
	private String mbrNm;
	private String telno;
	private String engSurname;
	private String engNm;
	private String nickname;
	private String brdt;
	private String gender;
	private String pswd;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp pswdChgDt;
	private String tmprPswdIssuYn;
	private String mbrGradeCd;
	private String mbrTycd;
	private String mbrCategoryCd;
	private String koreanYn;
	private String ntnCd;
	private String languageCd;
	private String emlRcptnYn;
	private String snsRcptnYn;
	private String messageRcptnYn;
	private String wishedUseYn;
	private String disabledYn;
	private String meritoYn;
	private String lgnAllowYn;
	private String rewardAplcnYn;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joinYmd;
	private String memo;
	private String mbrState;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp whdwlDt;
	private String whdwlWhy;
	private String identityTycd;
	private String identityCiCd;
	private String identityDiCd;
	private String delYn;
	private String suggestionMbrNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp crtDt;
	private String creater;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp mdfcnDt;
	private String mdfr;
	private String ntnTelno;

	/* 화면 추가 vo */
	private String toDate;
	private String fromDate;
	private String snsTycd;

	/* Code Name vo */
	private String mbrGradeCdNm;
	private String mbrTycdNm;
	private String mbrCategoryCdNm;
	private String ntnCdNm;
	private String languageCdNm;
	private String mbrStateNm;



	/* t_easylogin      */
	private String easyloginUid;       /*   간편로그인식별자 일련번호-'0001'    */
	private String snsId;       /*   SNS아이디    */
	private String snsToken;       /*   SNS토큰    */
	private Timestamp linkBgngDt;       /*   연계시작일시    */
	private Timestamp linkEndDt;       /*   연계종료일시    */
	private String linkYn;       /*   연계여부    */

	/* t_interest_area  */
	private String interestAreaUid;       /*   관심분야식별자    */
	private String zoneCd;       /*   지역코드    */
	private String categoryUid;       /*   분류식별자    */

	/* t_interest_gds   */
	private String gdsUid;       /*   상품식별자 GO    */

	/* t_bad_mbr        */
	private String badMbrUid;       /*   불량회원식별자 일련번호-'0001'    */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dclrYmd;       /*   신고일자    */
	private String dclrRecord;       /*   신고내역    */
	private String dclrMbrNo;       /*   신고회원번호    */

	/* t_anyone         */

	/* t_idcard         */
	private String idcardUid;       /*   신분증식별자 일련번호-'0001'    */
	private String idcardTycd;       /*   신분증구분코드    */
	private String idcardNo;       /*   신분증번호    */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date idcardMtryDay;       /*   신분증만기일    */
	private String fileUid;       /*   파일식별자 FI    */

	/* t_trms_agre      */
	private String trmsUid;       /*   약관식별자    */
	private String agreYn;       /*   동의여부    */
	private Timestamp agreDt;       /*   동의일시    */


	/* t_cert           */
	private String certUid;       /*   인증식별자    */
	private String certCoNm;       /*   인증회사명    */
	private String certTycd;       /*   인증구분코드    */
	private Timestamp certDt;       /*   인증일시    */
	private String certIp;       /*   인증IP    */


	/* t_cart           */
	private String cartUid;       /*   장바구니식별자 CT seq_cart_ct    */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date checkinYmd;       /*   체크인일자    */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date checkoutYmd;       /*   체크아웃일자    */
	private LocalTime checkinHr;       /*   체크인시간    */
	private Double gramt;       /*   총금액    */
	private Timestamp prchsDt;       /*   구매일시    */
	private String prchsStateType;       /*   구매상태구분    */
	private Timestamp stateDt;       /*   상태일시    */
	private String stateWhy;       /*   상태사유    */
	private String custDmndRecord;       /*   고객요청내역    */
	private String gdsDtlUid;       /*   상품상세식별자    */

	/* t_cart_record    */
	private String cartRecordUid;       /*   장바구니내역식별자    */
	private String gdsAddUid;       /*   상품추가식별자    */
	private String uidTycd;       /*   식별자구분코드    */
	private String ticketNo;       /*   티켓번호    */
	private String barcdNo;       /*   바코드번호    */
	private String priceType;       /*   가격구분    */
	private Double prchsCnt;       /*   구매수    */
	private Double price;       /*   가격    */
	private Double useCnt;       /*   사용수    */




	/* t_cntn_log       */
	private String cntnLogUid;       /*   접속로그식별자 LG seq_login_lg    */
	private Timestamp cntnDt;       /*   접속일시    */
	private String cntnIp;       /*   접속IP    */
	private String cntnUrl;       /*   접속URL    */
	private String cntnLoc;       /*   접속장소    */
	private String cntnHow;       /*   접속방법    */
	private String cntnTycd;       /*   접속구분코드    */


	/* t_mbr            */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date whdwlYmd;       /*   탈퇴일자    */
    private Double remainPointScore;       /*   잔여포인트점수    */
    private Double expiredPrnmntPointScore;       /*   소멸예정포인트점수    */
    private String exrateCd;       /*   환율코드    */
    private String autoLgnYn;       /*   자동로그인여부    */
    private Double pswdFailTimes;       /*   비번실패횟수    */
    private String eventRcptnYn;     /*이벤트 수신여부(마케팅구독/약관 동의여부)*/


	/* t_mbr_dtl        */
    private String birthday;       /*   생일    */
    private String mblTelno;       /*   휴대전화번호    */
    private String zip;       /*   우편번호    */
    private String addr;       /*   주소    */
    private String addrDtl;       /*   주소상세    */
    private String abodeZip;       /*   거소우편번호    */
    private String abodeAddr;       /*   거소주소    */
    private String abodeAddrDtl;       /*   거소주소상세    */
    private String mrgYn;       /*   결혼여부    */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date mrgAnniversary;       /*   결혼기념일    */
    private String suggestionMbrUid;       /*   추천회원식별자    */

	/* t_mbr_add_info   */
    private String mbrAddInfoUid;       /*   회원추가정보식별자    */
    private String mbrInfoTycd;       /*   회원정보구분코드    */
    private String fieldCd;       /*   필드코드    */
    private String infoCn;       /*   정보내용    */
    private String yr;       /*   연도    */
    private String mm;       /*   월    */

    /* t_hope_trpl */
    private String hopeTrplUid;      /*   희망여행지식별자    */
    private String trplNm;      /*   여행지명    */
    private String trplIntro;      /*   여행지소개    */
    private String ctpvCd;      /*   시도코드    */
    private String sggCd;      /*   시군구코드    */
    private String category1Cd;      /*   대분류코드    */
    private String category3Cd;      /*   소분류코드    */
    private String activeYn;      /*   활성여부    */
    private String attractionsUid;      /*   관광지식별자 TR    */


    /*
     * ------------- W2SK -------------
     */

    /* Parameters */
	private String[] paramCategories;
	private String[] paramGrades;
	private String[] paramStates;
	private String[] paramStatuses;
	private String paramSearch;
	private String paramPeriodType;
	private String paramUid;
    private String paramFromDate;
    private String paramToDate;
    private String paramuserEml;

	/* Auth */
	private String authId;

	/* Body */
	private String[] ids;

	/* Methods */
	public MemberVO assign(UsersParams params) {
        if (params != null) {
            this.paramUid = BaseParams.toString(params.getUid());
            this.paramCategories = BaseParams.toStringArray(params.getType());
            this.paramGrades = BaseParams.toStringArray(params.getGrade());
            this.paramStatuses = BaseParams.toStringArray(params.getStatus());
            this.paramStates = BaseParams.toStringArray(params.getState());
            this.paramSearch = BaseParams.toString(params.getSearch());
            this.paramPeriodType = BaseParams.toString(params.getPeriodType());
            this.paramFromDate = BaseParams.toString(params.getFromDate());
            this.paramToDate = BaseParams.toString(params.getToDate());
            this.paramuserEml = UsersParams.toString(params.getUserEml());
        }

        return this;
	}

    public MemberVO assign(UsersDTO users) {
        if (users != null) {
            this.authId = users.getAuth();
            this.ids = BaseParams.toStringArray(users.getIds());
        }

        return this;
    }

    public MemberVO assign(UsersProfileDTO profile)  {
        if (profile != null) {
            this.mbrUid = profile.getCode();
            this.mbrNm = profile.getName();
            this.eml = profile.getEmail();
            this.telno = profile.getPhoneNumber();
            this.mbrCategoryCd = profile.getCategoryCode();
            this.mbrGradeCd = profile.getMembershipGradeCode();
            this.mbrState = profile.getState();
            this.mbrTycd = profile.getBizTypeCode();
            if (profile.getPswd() != null) {
                this.pswd = encrypt(profile.getPswd());
            }
            this.engSurname = profile.getEngSurname();
            this.gender = profile.getGender();
            this.brdt = profile.getBrdt();
            this.ntnCd = profile.getNtnCd();
            this.ntnTelno = profile.getNtnTelno();
            this.languageCd = profile.getLanguageCd();
            this.eventRcptnYn = profile.getEventRcptnYn();
            this.creater = profile.getCreater();
            this.mdfr = profile.getMdfr();
        }

        return this;
    }

    public String encrypt(String str)  {
        String sha = "";
        MessageDigest sh = null;
		try {
			sh = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
        sh.update(str.getBytes());
        byte byteData[] = sh.digest();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
        }
        sha = sb.toString();
        return sha;
    }

	@Override
    public MemberVO assignPagination(BaseParams params) {
        return (MemberVO) super.assignPagination(params);
	}

}
