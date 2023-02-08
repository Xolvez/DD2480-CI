package com.example.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    private GithubRequest githubRequest;

    private Author author;
    @Test
    void testName() {
        author = new Author();
        author.setName("test");
        assertEquals(author.getName(), "test");
    }
    @Test
    void testEmail() {
        author = new Author();
        author.setEmail("test@test.test");
        assertEquals(author.getEmail(), "test@test.test");
    }

}