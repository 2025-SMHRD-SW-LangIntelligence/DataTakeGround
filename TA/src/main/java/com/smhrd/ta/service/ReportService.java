package com.smhrd.ta.service;

import com.smhrd.ta.entity.Report;
import com.smhrd.ta.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> findAllReports() {
        return reportRepository.findAll();
    }

    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    public Report findById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
    
    public List<Report> searchReports(String type, String keyword) {
        if ("id".equals(type)) {
            return reportRepository.findByIdContaining(keyword);
        } else if ("content".equals(type)) {
            return reportRepository.findByContentContaining(keyword);
        } else if ("location".equals(type)) {
            return reportRepository.findByLocationContaining(keyword);
        } else {
            return new ArrayList<>(); // 검색 조건이 일치하지 않으면 빈 리스트
        }
    }

	public static void write(Report report) {
		
	}

}
