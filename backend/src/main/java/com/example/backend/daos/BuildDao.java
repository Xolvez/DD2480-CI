package com.example.backend.daos;

import com.example.backend.models.Build;

import java.util.List;

public interface BuildDao {

    public Build insert(Build build);

    public List<Build> findAll();
}
