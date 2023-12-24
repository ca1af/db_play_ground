package com.example.dbpartitioning.foo.service;

import com.example.dbpartitioning.foo.aop.ExeTimer;
import com.example.dbpartitioning.foo.dao.JdbcBulkInsertRepository;
import com.example.dbpartitioning.foo.vo.InsertVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class BulkInsertService {
    private final JdbcBulkInsertRepository jdbcBulkInsertRepository;
    private final TimeCheckService timeCheckService;
    @Transactional(rollbackFor = Exception.class)
    @ExeTimer
    public void initDummies(InsertVO insertVO) {
        int count = insertVO.getTrialCount();
        List<String> fooNewList = new ArrayList<>();
        while (count-- > 0) {
            List<String> fooNames = IntStream.rangeClosed(1, 5)
                    .mapToObj(i -> "FOO" + i)
                    .toList();
            fooNewList.addAll(fooNames);
        }
        long exeTime = jdbcBulkInsertRepository.bulkInsert(fooNewList, insertVO.getTableName().getName());
        timeCheckService.saveTime(insertVO.getTableName().getName(), exeTime);
    }
}