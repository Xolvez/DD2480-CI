package com.example.backend.controller;

import com.example.backend.services.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("build")
public class BuildController {
    @Autowired
    public BuildService buildService;

    @PostMapping("/")
    @ResponseBody
    public String createBuild () {
    return "dd2480ci"
    }
}
