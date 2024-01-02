package com.example.dbpartitioning.foo.vo;

import lombok.Data;
@Data
public class InsertByNameVO {
    private int trialCount;
    private TableName tableName;
    private FooName fooName;
}
