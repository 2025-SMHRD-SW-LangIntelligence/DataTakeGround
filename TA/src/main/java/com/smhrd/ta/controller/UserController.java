package com.smhrd.ta.controller;

import com.smhrd.ta.entity.User;
import com.smhrd.ta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String showJoinPage() {
        return "join";  // templates/join.html
    }

    @ResponseBody
    @GetMapping("/check-username")
    public boolean checkUsername(@RequestParam String username) {
        return userService.isUsernameAvailable(username);
    }

    @PostMapping("/join")
    public String joinUser(User user) {  // form 필드 이름이 User 필드와 일치해야 함
        userService.registerUser(user);
        return "redirect:/login";
    }
}
