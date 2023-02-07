package com.example.backend.daoImpls;

import com.example.backend.daos.BuildDao;
import com.example.backend.models.Build;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
class BuildDaoImplTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BuildDao buildDao;

    @BeforeEach
    @AfterEach
    void clearBuilds() {
        mongoTemplate.dropCollection(Build.class);
    }

    @Test
    void insert() {
        Build build = new Build();
        Build insertedBuild = buildDao.insert(build);

        assertNotNull(insertedBuild);
        assertNotNull(insertedBuild.getId());
    }

    @Test
    void findAll() {
        assertEquals(0, buildDao.findAll().size());

        buildDao.insert(new Build());
        assertEquals(1, buildDao.findAll().size());

        buildDao.insert(new Build());
        assertEquals(2, buildDao.findAll().size());
    }
}