package com.example.backend.controller;

import com.example.backend.services.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("build")
public class BuildController {
    @Autowired
    public BuildService buildService;
    
}
