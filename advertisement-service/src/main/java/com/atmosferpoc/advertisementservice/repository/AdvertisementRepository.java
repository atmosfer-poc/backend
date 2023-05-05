package com.atmosferpoc.advertisementservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.JobAdvertisements;
import com.atmosferpoc.shared.model.type.JobAdvertisementStatus;

import java.util.List;

public interface AdvertisementRepository extends BaseJpaRepository<JobAdvertisements, Long> {
    List<JobAdvertisements> findAllByStatus(JobAdvertisementStatus status);

    boolean existsByTitle(String title);
}
