package com.example.backend.models;

public class GithubRequest {
    private String ref;
    private Repository repository;
    private Head_commit head_commit;
    public GithubRequest() {

    }

    public String getRef() {return ref;}
    public void setRef(String ref) { this.ref = ref; }
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
    public Repository getRepository() {
        return this.repository;
    }

    public void setHead_commit(Head_commit head_commit) {
        this.head_commit = head_commit;
    }
    public Head_commit getHead_commit() {
        return this.head_commit;
    }

}