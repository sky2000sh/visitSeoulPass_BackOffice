package com.visitSeoulPass.backoffice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// import com.kcp.api.common.APIResponse;
// import com.kcp.api.dto.CertEmailReqDTO;
// import com.kcp.api.dto.TokenDTO;
// import com.kcp.api.service.AuthService;
// import com.kcp.api.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RestControllerAdvice
public class AuthController {

    @Autowired
	private AuthService authService;
	

	@PostMapping("/auth/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberVO member) {
		Map<String, Object> resultData = new HashMap<String, Object>();
		
		resultData = authService.login(member);
		
		return new ResponseEntity<>(resultData, HttpStatus.OK);
	}

	@PostMapping("/auth/certify")
	public ResponseEntity<Map<String, Object>> certify(@RequestBody CertEmailReqDTO certReqDTO ) {
		return new ResponseEntity<>(authService.cert(certReqDTO), HttpStatus.OK);
	}
	@PostMapping("/auth/update-token")
	public ResponseEntity<Map<String, Object>> updateRefreshToken(@RequestBody TokenDTO dto){
		return new ResponseEntity<>(authService.updateRefeshToken(dto), HttpStatus.OK);
		
	}	
	
	@GetMapping("/auth/id")
	public ResponseEntity<Map<String, Object>> duplicateCheckToId(String userId ) {
		return new ResponseEntity<>(authService.duplicateCheckToId(userId), HttpStatus.OK);
	}
	@GetMapping("/auth/eml")
	public ResponseEntity<Map<String, Object>> certify(String userEml ) {
		return new ResponseEntity<>(authService.duplicateCheckToEmail(userEml), HttpStatus.OK);
	}

	@GetMapping("/test")
	public ResponseEntity<Map<String, Object>> getUserList() {
		return new ResponseEntity<>(authService.getUserInfo(), HttpStatus.OK);
	}

	@GetMapping("/testGetBoard")
	public ResponseEntity<Map<String, Object>> getBoardListByCategoty() {
		return new ResponseEntity<>(authService.getBoardListByCategoty(), HttpStatus.OK);
	}

	@PostMapping("/testInsert")
	public ResponseEntity<Map<String, Object>> insertUserTest(@RequestBody Map<String, Object> boardData) {
		return new ResponseEntity<>(authService.insertBoardTest(boardData), HttpStatus.OK);
	}

	@GetMapping("/message")
	public String test() {
		return "spring boot is working";
	}

}
