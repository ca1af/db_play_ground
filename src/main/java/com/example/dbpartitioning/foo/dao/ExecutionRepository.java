package com.example.dbpartitioning.foo.dao;

import com.example.dbpartitioning.foo.entity.ExecutionTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionRepository extends JpaRepository<ExecutionTime, Long> {
}
