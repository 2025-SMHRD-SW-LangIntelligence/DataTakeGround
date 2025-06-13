package com.smhrd.ta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    // 로그인 페이지 GET 요청
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // templates/login.html 렌더링
    }

    // 로그인 요청 POST 처리
    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        // 임시 로그인 검증 로직
        if ("admin".equals(username) && "1234".equals(password)) {
            model.addAttribute("msg", "로그인 성공!");
        } else {
            model.addAttribute("msg", "로그인 실패!");
        }
        return "login"; // 결과 메시지 같이 보여줌
    }
}
