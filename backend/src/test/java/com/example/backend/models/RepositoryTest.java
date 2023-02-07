package com.example.backend.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Autowired
    private Repository repository;
    @Test
    void testClone_url() {
        repository = new Repository();
        repository.setClone_url("clone_url_test");
        assertEquals(repository.getClone_url(), "clone_url_test");
    }

}