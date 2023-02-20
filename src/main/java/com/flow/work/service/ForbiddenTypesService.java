package com.flow.work.service;

import com.flow.work.domain.entity.ForbiddenTypes;
import com.flow.work.repository.ForbiddenTypesRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForbiddenTypesService {

  private final ForbiddenTypesRepository forbiddenTypesRepository;

  public List<ForbiddenTypes> getAllInfo() {
    return forbiddenTypesRepository.findAll();
  }

  public Long countAllInfo() {
    return forbiddenTypesRepository.count();
  }

  public void addType(String typeName) {
    ForbiddenTypes forbiddenTypes = forbiddenTypesRepository.findByForbiddenTypeName(typeName)
        .orElseGet(
            () -> {
              ForbiddenTypes newForbiddenTypes = ForbiddenTypes.of(typeName);
              forbiddenTypesRepository.save(newForbiddenTypes);
              return newForbiddenTypes;
            }
        );
  }

  public void deleteForbiddenType(String forbiddenTypeName) {
    forbiddenTypesRepository.delete(forbiddenTypesRepository.findByForbiddenTypeName(forbiddenTypeName)
        .orElseThrow(() -> {
          throw new RuntimeException();
        }));
  }
}
