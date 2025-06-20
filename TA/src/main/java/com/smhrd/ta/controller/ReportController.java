package com.smhrd.ta.controller;


import java.util.ArrayList;
import java.util.List;

import com.smhrd.ta.entity.Report;
import com.smhrd.ta.entity.ReportImg;
import com.smhrd.ta.service.ReportService;

import jakarta.servlet.http.HttpSession;

import com.smhrd.ta.entity.User; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // 게시글 목록 보기
    @GetMapping("/list")
    public String listReports(Model model) {
        List<Report> reports = reportService.findAllReports();
        model.addAttribute("reports", reports);
        return "reportList";  // reportList.html
    }
    
    
    // 비회원 유저 게시글 작성 제한.
    
    @GetMapping("/new")
    public String showForm(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }

        model.addAttribute("report", new Report());
        return "reportForm";  // reportForm.html
    }

    // 게시글 저장 처리 (파일 업로드 포함)
    @PostMapping("/save")
    public String saveReport(@ModelAttribute Report report,
                             @RequestParam("file") MultipartFile file,
                             HttpSession session) throws IOException {
    	System.out.println("saveReport 메서드 진입");
   

        // 로그인한 사용자 확인
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        report.setUsername(loginUser.getUsername());

        report.setWriteDay(LocalDate.now());

        // 이미지 저장
        if (!file.isEmpty()) {
            String originalName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String savedName = uuid + "_" + originalName;

            // 실제 저장
            String uploadPath = "C:/upload/";  // 절대경로로 변경

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                boolean created = uploadDir.mkdirs();
                System.out.println("upload 폴더 생성 여부: " + created);
            }

            file.transferTo(new File(uploadPath + savedName));

            // 이미지 객체 생성 및 연결
            ReportImg reportImg = new ReportImg();
            reportImg.setImgUrl("/upload/" + savedName);

            report.addImage(reportImg);  // 양방향 관계 자동 설정 
        }

        // 저장
        reportService.saveReport(report);
        return "redirect:/report/list";
    }


    
    
}
