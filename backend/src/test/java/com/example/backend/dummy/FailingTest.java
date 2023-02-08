package com.example.backend.dummy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//This is a test that should fail. Used to test the testing functionality on main branch.
public class FailingTest {
    @Test
    void failingTest() {
        assertTrue(false);
    }
}
