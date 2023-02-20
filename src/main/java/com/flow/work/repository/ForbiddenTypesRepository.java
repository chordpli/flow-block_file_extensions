package com.flow.work.repository;

import com.flow.work.domain.entity.ForbiddenTypes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForbiddenTypesRepository extends JpaRepository<ForbiddenTypes, Long> {

  Optional<ForbiddenTypes> findByForbiddenTypeName(String typeName);
}
