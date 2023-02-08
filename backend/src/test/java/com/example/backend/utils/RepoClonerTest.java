package com.example.backend.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

@SpringBootTest
class RepoClonerTest {

    @Autowired
    private RepoCloner repoCloner;
    @Test
    void cloneRepo() {
        try{
            repoCloner.cloneRepo("test");
            //If the repo was cloned correctly, it should contain a folder called backend.
            assertTrue(new File(repoCloner.getFilePath(),"backend").exists());

            //The repo should only contain the correct files.
            assertFalse(new File(repoCloner.getFilePath(),"thisFileDoesNotExist").exists());
        }
        catch (Exception e) {
            fail(e);
        }
    }

}