package com.atmosferpoc.entity.parameter.repository;

import com.atmosferpoc.core.model.type.SystemParameterKeyType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.SystemParameters;
import com.atmosferpoc.shared.model.pojo.ValuePojo;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SystemParametersRepository extends BaseJpaRepository<SystemParameters, Long> {
    @Query("SELECT new com.atmosferpoc.shared.model.pojo.ValuePojo(s.value) from SystemParameters s where s.key = :key")
    Optional<ValuePojo> findValueByKey(SystemParameterKeyType key);

    Optional<SystemParameters> findByKey(SystemParameterKeyType key);
}
