package com.example.backend.services;

public interface EmailService {
    /** Send email about the build success to the address **/
    public void email_success(String to_email);
    /** Send email about the build failure to the address **/
    public void email_failure(String to_email);
}
