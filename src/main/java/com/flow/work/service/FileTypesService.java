package com.flow.work.service;

import com.flow.work.domain.entity.FileTypes;
import com.flow.work.repository.FileTypesRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileTypesService {

  private final FileTypesRepository fileTypesRepository;

  public List<FileTypes> getSavedType() {
    return fileTypesRepository.findAllByFileTypeNoAfter(7L);
  }

  public void addNewType(String extension) {
    FileTypes fileType = FileTypes.of(extension);
    fileTypesRepository.save(fileType);
  }

  public void deleteType(String extension) {
    FileTypes fileType = fileTypesRepository.findByTypeName(extension)
        .orElseThrow(()->{
          throw new RuntimeException();
        });
    fileTypesRepository.delete(
        fileTypesRepository.findById(fileType.getFileTypeNo())
            .orElseThrow(RuntimeException::new));
  }
}
