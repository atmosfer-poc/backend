package com.atmosferpoc.logservice.repository;

import com.atmosferpoc.logservice.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
