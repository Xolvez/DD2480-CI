package com.example.backend.utils;

import java.io.File;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProcessGeneratorTest {

    private ProcessGenerator processGenerator = new ProcessGenerator();
    private RepoCloner repoCloner = new RepoCloner();

    @Test
    //Compile the test project. The project should compile, so getStatus() should return true.
    void compileProject() {
        try{
            repoCloner.cloneRepo("test");
            processGenerator.setDirectory(new File(repoCloner.getFilePath(),"backend"));
            processGenerator.compileProject();
            assertTrue(processGenerator.getStatus());
        }
        catch (Exception e) {
            fail(e);
        }
    }

    @Test
    //Test the test project. A test case is set to fail, so getStatus should return false.
    void testProject() {
        try{
            repoCloner.cloneRepo("test");
            processGenerator.setDirectory(new File(repoCloner.getFilePath(),"backend"));
            processGenerator.testProject();
            assertFalse(processGenerator.getStatus());
        }
        catch (Exception e) {
            fail(e);
        }
    }

}