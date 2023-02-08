package com.example.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document("build")
public class Build {

    @Id
    private String id;

    private String commitID;

    private String build_date;

    private boolean build_success;

    private String build_message;

    public String getCommitID() {
        return commitID;
    }

    public void setCommitID(String commitID) {
        this.commitID = commitID;
    }

    public String getBuild_date() {
        return build_date;
    }

    public void setBuild_date(String build_date) {
        this.build_date = build_date;
    }

    public boolean isBuild_success() {
        return build_success;
    }

    public void setBuild_success(boolean build_success) {
        this.build_success = build_success;
    }

    public String getBuild_message() {
        return build_message;
    }

    public void setBuild_message(String build_message) {
        this.build_message = build_message;
    }

    public Build() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
