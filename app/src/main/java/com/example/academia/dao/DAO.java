package com.example.academia.dao;

import com.example.academia.model.Models;
import com.example.academia.model.Student;

import java.util.List;

public abstract class DAO {
    public abstract Models selectById(Integer id);
    public abstract boolean insert(Models model);

}
