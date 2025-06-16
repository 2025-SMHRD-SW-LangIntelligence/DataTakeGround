package com.smhrd.ta.controller;

import com.smhrd.ta.entity.User;
import com.smhrd.ta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getPassword().equals(password)) {
                session.setAttribute("loginUser", user);
                return "redirect:/"; // 성공 시 메인페이지
            }
        }

        // 실패 시 login.html 렌더링, 메시지 전달
        model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
        return "login"; // templates/login.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
