package com.example.backend.models;

public class Head_commit {
    private String id;

    private String message;
    private String url;
    private Author author;

    public Head_commit() {

    }
    public String getId() {return id;}
    public void setId(String id) { this.id = id; }
    public String getMessage() {return message;}
    public void setMessage(String message) { this.message = message; }
    public String getUrl() {return url;}
    public void setUrl(String url) { this.url = url; }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public Author getAuthor() {
        return this.author;
    }
}
