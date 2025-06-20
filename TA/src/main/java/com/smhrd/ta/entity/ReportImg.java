package com.smhrd.ta.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Report_img")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Img_id")
    private Long imgId;

    @Column(name = "ImgUrl")
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportID")  // FK: Report 테이블의 PK 참조
    private Report report;

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setReport(Report report) {
        this.report = report;
    }

}
