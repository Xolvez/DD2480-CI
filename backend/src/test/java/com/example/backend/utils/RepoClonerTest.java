package com.example.backend.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

class RepoClonerTest {

    private RepoCloner repoCloner = new RepoCloner();
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