package com.example.backend.utils;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
public class RepoCloner {
    public RepoCloner(){};
    File localPath;
    /*
     * Clones the branch branchName to a temporary folder. Requires GitHub authentication token/access to the project.
     */
    public void cloneRepo(String branchName) throws InvalidRemoteException, TransportException, GitAPIException, IOException {
        localPath = File.createTempFile("testFolder", "");
        Files.delete(localPath.toPath());
        Git.cloneRepository()
          .setURI("https://github.com/Xolvez/DD2480-CI.git")
          .setDirectory(localPath)
          .setBranch(branchName)
          .call();
        
          //To test this code, run a mvn command in the directory "new File(localPath,"backend")"
    }
    /*
     * Get the path to the generated temporary folder.
     */
    public File getFilePath() {
        return localPath;
    }
}
