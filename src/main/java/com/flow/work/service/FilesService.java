package com.flow.work.service;

import com.flow.work.domain.dto.FileUploadRequest;
import com.flow.work.domain.entity.Files;
import com.flow.work.domain.entity.FileTypes;
import com.flow.work.domain.entity.ForbiddenTypes;
import com.flow.work.repository.FileRepository;
import com.flow.work.repository.FileTypesRepository;
import com.flow.work.repository.ForbiddenTypesRepository;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilesService {

  private final FileRepository fileRepository;
  private final S3FileUploadService s3FileUploadService;
  private final FileTypesRepository fileTypeRepository;
  private final ForbiddenTypesRepository forbiddenTypesRepository;

  public void uploadFile(FileUploadRequest request) throws IOException {
    checkFileEmpty(request);
    String url = s3FileUploadService.uploadFile(request.getFile());
    String fileExtension = StringUtils.getFilenameExtension(url);
    FileTypes fileType = validateFileTypesAndGet(fileExtension);
    checkForbiddenTypes(fileExtension);
    Files file = Files.of(fileType, url);
    fileRepository.save(file);
  }

  private void checkFileEmpty(FileUploadRequest request) {
    if (request.getFile().isEmpty()) {
      throw new RuntimeException();
    }
  }

  private FileTypes validateFileTypesAndGet(String fileExtension) {
    return fileTypeRepository.findByFileTypeName(fileExtension).orElseGet(
        () -> {
          FileTypes newFileTypes = FileTypes.of(fileExtension);
          fileTypeRepository.save(newFileTypes);
          return newFileTypes;
        }
    );
  }

  private void checkForbiddenTypes(String fileExtension) {
    List<ForbiddenTypes> forbiddenTypes = forbiddenTypesRepository.findAll();
    for (ForbiddenTypes forbiddenType : forbiddenTypes) {
      if (forbiddenType != null && fileExtension.equals(forbiddenType.getForbiddenTypeName())) {
        throw new RuntimeException();
      }
    }
  }
}
