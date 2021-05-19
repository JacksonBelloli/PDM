package com.example.academia.dao;

import com.example.academia.model.Graduation;
import com.example.academia.model.Models;
import com.example.academia.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GraduationDAO extends DAO {

    public List<Graduation> selectAll() {
        List<Graduation> graduations = new ArrayList<Graduation>();

        for(Integer i=0;i<100;i++) {
            Graduation graduation = new Graduation();
            graduation.setId(i);
            graduation.setNome("Grad " + i.toString());
            graduations.add(graduation);
        }


        return graduations;
    }

    public Graduation selectById(Integer id) {
        Graduation graduation = new Graduation();
        graduation.setId(id);
        graduation.setNome("Grad " + id.toString());

        return graduation;
    }

    @Override
    public boolean insert(Models model) {
        Graduation graduation = (Graduation) model;
        return true;
    }

    public List<Graduation> selectByIdModality(Integer idModality) {
        List<Graduation> graduations = new ArrayList<Graduation>();

        for(Integer i=0;i<100;i++) {
            Graduation graduation = new Graduation();
            graduation.setId(i);
            graduation.setNome("Grad " + i.toString());
            graduations.add(graduation);
        }


        return graduations;
    }
}
