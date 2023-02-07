package com.example.backend.services;

import com.example.backend.models.Build;

import java.util.List;

public interface BuildService {

    public Build insert(Build build);

    public List<Build> findAll();
}

