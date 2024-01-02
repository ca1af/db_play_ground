package com.example.dbpartitioning.foo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExecutionTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private String tableName;
    @Column(nullable = false)
    private long actualExeTime;
    @Builder
    public ExecutionTime(String tableName, long actualExeTime) {
        this.tableName = tableName;
        this.actualExeTime = actualExeTime;
    }
}
