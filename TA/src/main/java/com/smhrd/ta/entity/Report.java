package com.smhrd.ta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Report`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportId")
    private Long reportId;

    @Column(name = "Content")
    private String content;

    @Column(name = "WriteDay")   // DB 컬럼명이 'WritDay'로 오타가 있는 경우 이렇게 맞춰야 합니다.
    private LocalDate writeDay;

    @Column(name = "ID")
    private String id;

    @Column(name = "Location")
    private String location;
    
 // 파일 경로를 저장할 필드 추가
    private String imgPath;

    // Getter and Setter 추가
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }


    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReportImg> images = new ArrayList<>();

    public void setWriteDay(LocalDate now) {
        this.writeDay = now;
    }

    public void setUsername(String username) {
        this.id = username;
    }
    
    public String getContent() {
        return content;
    }

    
    public Long getReportId() {
        return reportId;
    }
    
    public String getId() {
        return id;
    }
    
    public LocalDate getWriteDay() {
        return writeDay;
    }

    public String getLocation() {
        return location;
    }




    

    public void setImages(List<ReportImg> imageList) {
        this.images = imageList;
        for (ReportImg img : imageList) {
            img.setReport(this);
        }
    }

    public void addImage(ReportImg img) {
        images.add(img);
        img.setReport(this);
    }
}
