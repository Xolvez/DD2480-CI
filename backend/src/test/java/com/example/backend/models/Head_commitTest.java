package com.example.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Head_commitTest {
    private Head_commit head_commit;
    @Test
    void testId() {
        head_commit = new Head_commit();
        head_commit.setId("test_id");
        assertEquals(head_commit.getId(), "test_id");
    }
    @Test
    void testMessage() {
        head_commit = new Head_commit();
        head_commit.setMessage("test_message");
        assertEquals(head_commit.getMessage(), "test_message");
    }

    @Test
    void testUrl() {
        head_commit = new Head_commit();
        head_commit.setUrl("test_url");
        assertEquals(head_commit.getUrl(),"test_url");
    }

    @Test
    void testAuthor() {
        head_commit = new Head_commit();
        Author author = new Author();
        head_commit.setAuthor(author);
        assertNotNull(head_commit.getAuthor());
    }
}