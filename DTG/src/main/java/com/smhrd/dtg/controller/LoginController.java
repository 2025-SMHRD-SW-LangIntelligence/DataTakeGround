package com.smhrd.dtg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html 렌더링
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        // 여기서 로그인 검증 로직을 수행할 수 있습니다
        System.out.println("입력한 아이디: " + username);
        System.out.println("입력한 비밀번호: " + password);

        // 예시: 성공하면 메인 페이지로 이동
        return "redirect:/";
    }
}
