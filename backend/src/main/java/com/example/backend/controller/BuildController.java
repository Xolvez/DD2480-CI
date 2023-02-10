package com.example.backend.controller;

import com.example.backend.models.GithubRequest;
import com.example.backend.services.BuildService;
import com.example.backend.services.EmailService;
import com.example.backend.utils.ProcessGenerator;
import com.example.backend.utils.RepoCloner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Build;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BuildController {
    @Autowired
    private BuildService buildService;
    @Autowired
    private RepoCloner repoCloner;

    @Autowired
    private ProcessGenerator processGenerator;
    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public void createBuild (@RequestBody GithubRequest githubRequest) {
        System.out.println("Github request");
        String ref = githubRequest.getRef();
        String clone_url = githubRequest.getRepository().getClone_url();
        String message = githubRequest.getHead_commit().getMessage();
        String id = githubRequest.getHead_commit().getId();
        String url = githubRequest.getHead_commit().getUrl();
        String email = githubRequest.getHead_commit().getAuthor().getEmail();

        String branchName = ref.substring(ref.lastIndexOf("/") + 1);

        if(!branchName.equals("assessment")) {
            return;
        }

        try {
            repoCloner.cloneRepo(branchName);
            processGenerator.setDirectory(new File(repoCloner.getFilePath(),"backend"));
            processGenerator.testProject();
            boolean buildSuccess = processGenerator.getStatus();
            String buildMessage = processGenerator.getErrors();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String now = dtf.format(LocalDateTime.now());

            Build build = new Build();
            build.setBuild_date(now);
            build.setCommitID(id);
            build.setBuild_message(buildMessage);
            build.setBuild_success(buildSuccess);

            buildService.insert(build);

            if(buildSuccess) {
                emailService.email_success(email);
            }
            else {
                emailService.email_failure(email);
            }

            System.out.println("Success!!");
            return;
        }
        catch(Exception e) {
            System.out.println("Exception caught in createBuild");
            e.printStackTrace();
        }

        return;
    }

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Build> getBuilds() {
        return buildService.findAll();
    }
    
}
