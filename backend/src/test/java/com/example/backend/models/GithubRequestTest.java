package com.example.backend.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class GithubRequestTest {

    private GithubRequest githubRequest;

    @Test
    void testRef() {
        githubRequest = new GithubRequest();
        githubRequest.setRef("test");
        String ref = githubRequest.getRef();
        assertEquals(ref, "test");
    }
    @Test
    void testRepository() {
        githubRequest = new GithubRequest();
        Repository repository = new Repository();
        githubRequest.setRepository(repository);
        assertNotNull(githubRequest.getRepository());
    }
    @Test
    void testHead_commit() {
        githubRequest = new GithubRequest();
        Head_commit head_commit = new Head_commit();
        githubRequest.setHead_commit(head_commit);
        assertNotNull(githubRequest.getHead_commit());
    }
}