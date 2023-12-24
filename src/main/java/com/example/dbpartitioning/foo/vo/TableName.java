package com.example.dbpartitioning.foo.vo;

import lombok.Getter;

public enum TableName {
    FOO("foo"),
    FOO_NEW("foo_new");
    @Getter
    private final String name;

    TableName(String name) {
        this.name = name;
    }
}
