package com.smhrd.ta.repository;

import com.smhrd.ta.entity.Report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByIdContaining(String id);         // 작성자 ID 검색
    List<Report> findByContentContaining(String content); // 내용 검색
    List<Report> findByLocationContaining(String location); // 위치 검색
}
