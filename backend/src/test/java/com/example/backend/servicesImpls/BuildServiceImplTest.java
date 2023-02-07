package com.example.backend.servicesImpls;

import com.example.backend.models.Build;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuildServiceImplTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BuildServiceImpl buildService;

    @BeforeEach
    @AfterEach
    void clearBuilds() {
        mongoTemplate.dropCollection(Build.class);
    }

    @Test
    void insert() {
        Build build = new Build();
        Build insertedBuild = buildService.insert(build);

        assertNotNull(insertedBuild);
        assertNotNull(insertedBuild.getId());
    }
}

