package com.example.dbpartitioning.foo.controller;

import com.example.dbpartitioning.foo.service.BulkInsertService;
import com.example.dbpartitioning.foo.vo.InsertByNameVO;
import com.example.dbpartitioning.foo.vo.InsertVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FooController {
    private final BulkInsertService bulkInsertService;
    @PostMapping("/insert")
    public void insertDummies(@RequestBody InsertVO insertVO){
        bulkInsertService.initDummies(insertVO);
    }

    @PostMapping("/insert/name")
    public void insertByName(@RequestBody InsertByNameVO insertByNameVO){
        bulkInsertService.insertParticularValue(insertByNameVO);
    }
}