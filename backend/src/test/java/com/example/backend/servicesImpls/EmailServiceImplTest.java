package com.example.backend.servicesImpls;

import com.example.backend.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmailServiceImplTest {
    @Autowired
    private EmailServiceImpl emailService;
    @Test
    void test_email() {
        String test_to_address = "ysiyang@126.com";
        emailService.email_success(test_to_address);
    }
}