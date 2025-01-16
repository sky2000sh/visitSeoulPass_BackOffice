package com.visitSeoulPass.backoffice.admin.auth.web;

import com.visitSeoulPass.backoffice.admin.auth.service.AuthService;
import com.visitSeoulPass.backoffice.web.dao.CertEmailReqDAO;
import com.visitSeoulPass.backoffice.web.dao.TokenDAO;
import com.visitSeoulPass.backoffice.web.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDAO> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(authService.login(username, password));
    }

    @PostMapping("/register")
    public ResponseEntity<MemberVO> register(@RequestBody MemberVO memberVO) {
        return ResponseEntity.ok(authService.register(memberVO));
    }

    @PostMapping("/send-verification-email")
    public ResponseEntity<Void> sendVerificationEmail(@RequestBody CertEmailReqDAO certEmailReqDAO) {
        authService.sendVerificationEmail(certEmailReqDAO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<Map<String, Object>> refreshToken(@RequestBody TokenDAO tokenDAO) {
        return ResponseEntity.ok(authService.updateRefeshToken(tokenDAO));
    }

    @GetMapping("/code")
    public ResponseEntity<Map<String, Object>> getCodeList() {
        return ResponseEntity.ok(authService.getCodeList(null));
    }

    @GetMapping("/check-id/{userId}")
    public ResponseEntity<Map<String, Object>> checkDuplicateId(@PathVariable String userId) {
        return ResponseEntity.ok(authService.duplicateCheckToId(userId));
    }

    @GetMapping("/check-email/{email}")
    public ResponseEntity<Map<String, Object>> checkDuplicateEmail(@PathVariable String email) {
        return ResponseEntity.ok(authService.duplicateCheckToEmail(email));
    }
}
