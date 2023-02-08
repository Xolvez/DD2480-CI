package com.example.backend.controller;

import com.example.backend.models.GithubRequest;
import com.example.backend.services.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Build;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("build")
public class BuildController {
    @Autowired
    public BuildService buildService;
    @PostMapping("")
    public String createBuild (@RequestBody GithubRequest githubRequest) {
        String ref = githubRequest.getRef();
        String clone_url = githubRequest.getRepository().getClone_url();
        String message = githubRequest.getHead_commit().getMessage();
        String id = githubRequest.getHead_commit().getId();
        String url = githubRequest.getHead_commit().getUrl();
        String email = githubRequest.getHead_commit().getAuthor().getEmail();

        return "dd2480ci";
    }

    @GetMapping("")
    public List<Build> getBuilds() {
        return buildService.findAll();
    }
    
}
