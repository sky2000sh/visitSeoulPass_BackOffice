package com.visitSeoulPass.backoffice.web.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import com.kcp.api.common.ResponseCode;
// import com.kcp.api.config.security.JwtManager;
// import com.kcp.api.config.security.JwtTokenProvider;
// import com.kcp.api.config.security.UserAuthentication;
// import com.kcp.api.dto.CertEmailReqDTO;
// import com.kcp.api.dto.TokenDTO;
import com.visitSeoulPass.backoffice.web.mapper.AuthMapper;
// import com.kcp.api.mapper.BoardMapper;
// import com.kcp.api.mapper.CodeMapper;
// import com.kcp.api.service2.CertService;
// import com.kcp.api.vo.BoardVO;
// import com.kcp.api.vo.CodeVO;
// import com.kcp.api.vo.MemberVO;
// import com.kcp.api.vo.PicVO;

// import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AuthService {

    @Autowired
	private AuthMapper authMapper;

	//@Autowired
	//private BoardMapper boardMapper;

	//@Autowired
	//private CodeMapper codeMapper;

	//@Autowired
	//private JwtManager jwtManager;

	//@Autowired
	//CertService certService;

	public Map<String, Object> getUserInfo() {
		Map<String, Object> res = new HashMap<>();
		try {
			authMapper.getUserList();
			res.put("success", authMapper.getUserList());
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	public Map<String, Object> getBoardListByCategoty() {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			List<BoardVO> boardList = boardMapper.getBoardListByCategoty();
			res.put("data", boardList);
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	public Map<String, Object> insertBoardTest(Map<String, Object> board) {
		Map<String, Object> res = new HashMap<>();
		try {
			int isSuccess = boardMapper.insertBoard(board);
			if (isSuccess > 0) {
				res.put("success", board);
			}
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	public Map<String, Object> login(MemberVO member) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			PicVO user = authMapper.getLoginUser(member.getId());

			if (user == null) {
				res.put("msg", "해당 유저정보가 없습니다");
				return res;
			} else if (!user.getPswd().equals(encrypt(member.getPswd()))) {
				res.put("msg", "비밀번호가 잘못되었습니다");
				return res;
			} else {
				certService.sendCode(user.getEml());
				user.setPswd(null);
				res.put("success", user);
			}
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	public Map<String, Object> cert(CertEmailReqDTO certReqDTO) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			String cert = certService.cert(certReqDTO);
			if (cert.equals("-2")) {
				res.put("msg", "유효시간이 지났습니다 다시 시도해주세요");
			} else if (cert.equals("-1")) {
				res.put("msg", "인증번호가 잘못되었습니다 다시 시도해주세요.");
			} else {
				// 메일인증하면 토큰 값 보내기
				JwtTokenProvider provider = new JwtTokenProvider();
				Authentication auth = new UserAuthentication(certReqDTO.getEml(), null, null);
				Map<String, String> refreshToken = JwtTokenProvider.generateRefreshToken(auth);
				Map<String, String> accessToken = JwtTokenProvider.generateAccessToken(auth);
				res.put("accessTokenExpiration",accessToken.get("expireDateTime"));
				res.put("refreshTokenExpiration",refreshToken.get("expireDateTime"));
				res.put("accessToken",accessToken.get("accessToken"));
				res.put("refreshToken",refreshToken.get("refreshToken"));
				res.put("success", true);
			}
		} catch (Exception e) {
			res = null;		
		}
		return res;
	}

	/**
	 * refreshToken 갱신
	 */
	public Map<String, Object> updateRefeshToken(TokenDTO dto) {
		Map<String, Object> res = new HashMap<String, Object>();

		String bearerToken = dto.getRefreshToken();
		if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
			bearerToken = bearerToken.substring("Bearer ".length());
						
			TokenDTO tokenResDTO = new TokenDTO();
			
			// 토큰 갱신
			if (JwtTokenProvider.validateToken(bearerToken)) {
				String userId = JwtTokenProvider.getUserIdFromJWT(bearerToken);
				Authentication auth = new UserAuthentication(userId, null, null);
				String accessToken = JwtTokenProvider.generateAccessToken(auth).get("accessToken");
				String refreshToken = JwtTokenProvider.generateRefreshToken(auth).get("refreshToken");
				String accessTime = JwtTokenProvider.generateAccessToken(auth).get("expireDateTime");
				String refreshTime = JwtTokenProvider.generateRefreshToken(auth).get("expireDateTime");
				tokenResDTO.setAccessToken(accessToken);
				tokenResDTO.setRefreshToken(refreshToken);
				res.put("accessTokenExpiration",accessTime);
				res.put("refreshTokenExpiration",refreshTime);
				res.put("accessToken", accessToken);
				res.put("refreshToken", refreshToken);
				// this.saveUserToken(userInfo.getMbrUid(), refreshToken);

			} else {
				log.error("token expired");
				res.put("fail", "token-expired");
			}
		} else {
			log.error("no token");
			res.put("fail", "token-not-found");
		}
		return res;
	}

	public Map<String, Object> getRefreshToken(String refreshToken) {
		Map<String, Object> res = new HashMap<>();
		try {
			Claims claim = jwtManager.getClaims(refreshToken);
		} catch (Exception e) {
			log.error("getRefreshToken");
		}

		return null;
	}

	public Map<String, Object> getCodeList(CodeVO code) {
		Map<String, Object> res = new HashMap<>();
		try {
			res.put("data", codeMapper.getCodeList(code));
		} catch (Exception e) {
			res = null;
		}

		return res;
	}

	public Map<String, Object> duplicateCheckToId(String userId) {
		Map<String, Object> res = new HashMap<>();
		try {
			int isDuplicate = authMapper.duplicateCheckToId(userId);
			if (isDuplicate > 0) {
				res.put("msg", "이미 가입된 회원입니다.");
			} else {
				res.put("success", true);
			}
		} catch (Exception e) {
			res = null;
		}

		return res;
	}

	public Map<String, Object> duplicateCheckToEmail(String userEml) {
		Map<String, Object> res = new HashMap<>();
		try {
			int isDuplicate = authMapper.duplicateCheckToEmail(userEml);
			if (isDuplicate > 0) {
				res.put("msg", "이미 가입 된 회원입니다.");
			} else {
				res.put("success", true);
			}
		} catch (Exception e) {
			res = null;
		}

		return res;
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
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		sha = sb.toString();
		return sha;
	}

}
