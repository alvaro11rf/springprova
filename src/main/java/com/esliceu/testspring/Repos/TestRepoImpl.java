package com.esliceu.testspring.Repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TestRepoImpl implements TestRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void save(String s) {
        jdbcTemplate.update("insert into test (name) values(?)", s);
    }
    public List<String> findallOperations(){
       List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from test");
    List<String> opList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> el = list.get(i);
            opList.add((String) el.get("name"));

        }
        return opList;



    }
}
