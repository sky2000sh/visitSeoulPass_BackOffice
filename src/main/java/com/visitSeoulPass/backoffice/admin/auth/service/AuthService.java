package com.visitSeoulPass.backoffice.admin.auth.service;

import com.visitSeoulPass.backoffice.admin.dao.CertEmailReqDAO;
import com.visitSeoulPass.backoffice.admin.dao.TokenDAO;
import com.visitSeoulPass.backoffice.admin.vo.CodeVO;
import com.visitSeoulPass.backoffice.admin.vo.MemberVO;
import com.visitSeoulPass.backoffice.admin.auth.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;

import io.jsonwebtoken.Claims;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;

    @Transactional
    public TokenDAO login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        TokenDAO tokenDAO = new TokenDAO();
        tokenDAO.setAccessToken("dummy-token"); // TODO: Implement JWT token generation
        tokenDAO.setTokenType("Bearer");
        return tokenDAO;
    }

    @Transactional
    public MemberVO register(MemberVO memberVO) {
        memberVO.setPswd(passwordEncoder.encode(memberVO.getPswd()));
        // TODO: Save member to database
        return memberVO;
    }

    @Transactional
    public void sendVerificationEmail(CertEmailReqDAO certEmailReqDAO) {
        // TODO: Implement email verification
    }

    @Transactional
    public CodeVO verifyEmail(String code) {
        CodeVO codeVO = new CodeVO();
        codeVO.setCode(code);
        codeVO.setType("EMAIL_VERIFICATION");
        codeVO.setIsActive(true);
        return codeVO;
    }

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
            List<CodeVO> boardList = authMapper.getBoardListByCategoty();
            res.put("data", boardList);
        } catch (Exception e) {
            res = null;
        }
        return res;
    }

    public Map<String, Object> insertBoardTest(Map<String, Object> board) {
        Map<String, Object> res = new HashMap<>();
        try {
            int isSuccess = authMapper.insertBoard(board);
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
            MemberVO user = authMapper.getLoginUser(member.getId());

            if (user == null) {
                res.put("msg", "해당 유저정보가 없습니다");
                return res;
            } else if (!user.getPswd().equals(hashPassword(member.getPswd()))) {
                res.put("msg", "비밀번호가 잘못되었습니다");
                return res;
            } else {
                //certService.sendCode(user.getEml());
                user.setPswd(null);
                res.put("success", user);
            }
        } catch (Exception e) {
            res = null;
        }
        return res;
    }

    public Map<String, Object> cert(CertEmailReqDAO certReqDTO) {
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            String cert = "";
            if (cert.equals("-2")) {
                res.put("msg", "유효시간이 지났습니다 다시 시도해주세요");
            } else if (cert.equals("-1")) {
                res.put("msg", "인증번호가 잘못되었습니다 다시 시도해주세요.");
            } else {
                // 메일인증하면 토큰 값 보내기
                //JwtTokenProvider provider = new JwtTokenProvider();
                //Authentication auth = new UserAuthentication(certReqDTO.getEml(), null, null);
                //Map<String, String> refreshToken = JwtTokenProvider.generateRefreshToken(auth);
                //Map<String, String> accessToken = JwtTokenProvider.generateAccessToken(auth);
                res.put("accessTokenExpiration","");
                res.put("refreshTokenExpiration","");
                res.put("accessToken", "");
                res.put("refreshToken", "");
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
    public Map<String, Object> updateRefeshToken(TokenDAO tokenDAO) {
        Map<String, Object> res = new HashMap<String, Object>();

        String bearerToken = tokenDAO.getRefreshToken();
        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
            bearerToken = bearerToken.substring("Bearer ".length());
                        
            TokenDAO tokenResDAO = new TokenDAO();
            
            // 토큰 갱신
            if (true) {
                String userId = "";
                Authentication auth = new UsernamePasswordAuthenticationToken(userId, null);
                String accessToken = "";
                String refreshToken = "";
                String accessTime = "";
                String refreshTime = "";
                tokenResDAO.setAccessToken(accessToken);
                tokenResDAO.setRefreshToken(refreshToken);
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
            Claims claim = null;
        } catch (Exception e) {
            log.error("getRefreshToken");
        }

        return null;
    }

    public Map<String, Object> getCodeList(CodeVO code) {
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", authMapper.getCodeList(code));
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

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
