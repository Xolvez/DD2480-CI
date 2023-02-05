package com.example.backend.daoImpls;

import com.example.backend.daos.BuildDao;
import com.example.backend.models.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class BuildDaoImpl implements BuildDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Build insert(Build build) {
        return mongoTemplate.insert(build, "build");
    }
}
