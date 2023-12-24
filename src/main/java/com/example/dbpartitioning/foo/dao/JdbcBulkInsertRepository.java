package com.example.dbpartitioning.foo.dao;

import com.example.dbpartitioning.foo.entity.Foo;
import com.example.dbpartitioning.foo.entity.FooNew;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcBulkInsertRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcBulkInsertRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional
    public long bulkInsert(List<String> fooNews, String tableName) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        String sql = "INSERT INTO " + tableName + " (name) " +
                "VALUES (?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                if (tableName.equals("fooNew")) {
                    FooNew fooNew = FooNew.builder()
                            .name(fooNews.get(i))
                            .build();
                    ps.setString(1, fooNew.getName());
                    return;
                }

                Foo entity = Foo.builder()
                        .name(fooNews.get(i))
                        .build();
                ps.setString(1, entity.getName());
            }

            @Override
            public int getBatchSize() {
                return fooNews.size();
            }
        });

        stopWatch.stop();

        return stopWatch.getTotalTimeMillis();
    }

}
