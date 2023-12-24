package com.example.dbpartitioning.foo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    @Getter
    private String name;
    @Builder
    public Foo(String name) {
        this.name = name;
    }
}
