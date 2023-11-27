package com.esliceu.testspring.Repos;

import com.esliceu.testspring.Entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationRepoImpl implements OperationRepo{
@Autowired
    JdbcTemplate jdbcTemplate;
    public void save(Operation operation) {
        jdbcTemplate.update("insert into operation (n1,n2,opType) values (?,?,?)",
                operation.getN1(),operation.getN2(),operation.getOpType());
    }

    @Override
    public List<Operation> findAll() {
        List<Operation> list = jdbcTemplate.query("select * from operation",
                new BeanPropertyRowMapper<>(Operation.class));
        return list;
    }
}
