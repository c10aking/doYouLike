package com.example.doyoulike.member.controller;

import com.example.doyoulike.member.dto.MemberDTO;
import com.example.doyoulike.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberId());
            return "main";
        } else {
            return "login";
        }
    }

    @GetMapping("/member/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/member/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.signup");
        System.out.println("memberDTO = " + memberDTO);
        memberService.signup(memberDTO);
        return "login";
    }

    @GetMapping ("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @PostMapping("/member/id-check")
    public @ResponseBody String idCheck(@RequestParam Long memberId) {
        System.out.println("memberId = " + memberId);
        String checkResult = memberService.idCheck(memberId);
        if (checkResult != null) {
            return "ok";
        } else {
            return "no";
        }
    }
}
