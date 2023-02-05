package com.example.backend.servicesImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.daos.BuildDao;
import com.example.backend.services.BuildService;

@Component
public class BuildServiceImpl implements BuildService{

    @Autowired
    private BuildDao buildDao;
}

