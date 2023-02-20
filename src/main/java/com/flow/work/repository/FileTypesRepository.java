package com.flow.work.repository;

import com.flow.work.domain.entity.FileTypes;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTypesRepository extends JpaRepository<FileTypes, Long> {

  Optional<FileTypes> findByFileTypeName(String extension);

  List<FileTypes> findAllByFileTypeNoAfter(Long fileTypeNo);
}
