package com.example.dbpartitioning.foo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foo_new")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FooNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    @Getter
    private String name;
    @Builder
    public FooNew(String name) {
        this.name = name;
    }
}
