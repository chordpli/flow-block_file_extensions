package com.flow.work.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Files {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long fileNo;

  private String fileUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "file_type_no")
  private FileTypes fileType;

  public static Files of(FileTypes fileType, String url) {
    return Files.builder()
        .fileType(fileType)
        .fileUrl(url)
        .build();
  }
}
