package com.atmosferpoc.advertisementservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.JobAdvertisementApplication;

import java.util.List;

public interface AdvertisementApplicationRepository extends BaseJpaRepository<JobAdvertisementApplication, Long> {
    List<JobAdvertisementApplication> findAllByJobId(Long jobId);
}
