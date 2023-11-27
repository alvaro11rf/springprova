package com.esliceu.testspring.Services;

import com.esliceu.testspring.Repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepo testRepo;

    public int suma(int n1, int n2) {
        int r = n1 + n2;
        String res = String.format(
                "%d + %d = %d",
                n1, n2, r);

        testRepo.save(res);
        return r;
    }

    public List<String> findallOperations() {
        //jdbcTemplate.queryForList("select * from test");
        //}
        return null;
    }
}

