package com.example.backend.controller;

import com.example.backend.services.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Build;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.backend.daos.BuildDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuildControllerTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BuildController buildController;
    
    @Autowired
    private BuildDao buildDao;

    @BeforeEach
    @AfterEach
    void clearBuilds() {
        mongoTemplate.dropCollection(Build.class);
    }

    @Test
    void findAll() {
        assertEquals(0, buildController.getBuilds().size());

        buildDao.insert(new Build());
        assertEquals(1, buildController.getBuilds().size());

        buildDao.insert(new Build());
        assertEquals(2, buildController.getBuilds().size());
    }
}
