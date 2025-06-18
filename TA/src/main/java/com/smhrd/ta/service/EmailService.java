package com.smhrd.ta.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String email) {
        String subject = "이메일 인증을 완료해주세요.";
        String token = "생성된토큰"; // 이건 실제로는 emailVerificationService.generateToken(email) 등으로 대체
        String verificationUrl = "http://localhost:8080/email/verify?token=" + token;
        String content = "아래 링크를 클릭하여 이메일 인증을 완료해주세요:\n\n" + verificationUrl;

        // ✅ 자기 클래스 내 메서드니까 this로 호출
        this.sendEmail(email, subject, content);
    }

    public void sendEmail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, false); // HTML X

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("이메일 전송 실패: " + e.getMessage(), e);
        }
    }
}
