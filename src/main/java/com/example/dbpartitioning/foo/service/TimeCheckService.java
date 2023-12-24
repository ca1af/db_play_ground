package com.example.dbpartitioning.foo.service;

import com.example.dbpartitioning.foo.dao.ExecutionRepository;
import com.example.dbpartitioning.foo.entity.ExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TimeCheckService {
    private final ExecutionRepository executionRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveTime(String tableName, long totalTimeMillis) {
        ExecutionTime executionTime = ExecutionTime.builder()
                .tableName(tableName)
                .executionTime(totalTimeMillis)
                .build();
        executionRepository.save(executionTime);
    }

}
