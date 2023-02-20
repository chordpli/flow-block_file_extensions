package com.flow.work.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FileTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long fileTypeNo;

  private String fileTypeName;

  public static FileTypes of(String extension) {
    return FileTypes.builder()
        .fileTypeName(extension)
        .build();
  }
}
