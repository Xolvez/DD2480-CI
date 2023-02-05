package com.example.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("build")
public class Build {

    @Id
    private String id;

    public Build() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
