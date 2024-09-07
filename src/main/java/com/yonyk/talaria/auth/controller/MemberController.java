package com.yonyk.talaria.auth.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyk.talaria.auth.controller.request.RegisterDTO;
import com.yonyk.talaria.auth.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

  private final MemberService memberService;

  // 회원가입 API
  @PostMapping
  public ResponseEntity<String> signUp(@Valid @RequestBody RegisterDTO registerDTO) {
    // 중복검증
    memberService.validMember(registerDTO);
    // 실제 회원가입
    memberService.signUp(registerDTO);
    return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
  }
}
