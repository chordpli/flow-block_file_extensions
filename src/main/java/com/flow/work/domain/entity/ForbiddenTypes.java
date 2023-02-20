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
public class ForbiddenTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long forbiddenTypeNo;

  private String forbiddenTypeName;

  public static ForbiddenTypes of(String typeName) {
    return ForbiddenTypes.builder()
        .forbiddenTypeName(typeName)
        .build();
  }
}
