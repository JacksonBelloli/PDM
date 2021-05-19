package com.example.academia.dao;

import com.example.academia.model.Matriculation;
import com.example.academia.model.Models;
import com.example.academia.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MatriculationDAO extends DAO {

    public List<Matriculation> selectAll() {
        List<Matriculation> matriculations = new ArrayList<Matriculation>();

        for(Integer i=0;i<100;i++) {
            Matriculation matriculation = new Matriculation();
            matriculation.setId(i);
            matriculation.setIdStudent(i);
            matriculations.add(matriculation);
        }


        return matriculations;
    }

    public Matriculation selectById(Integer id) {
        Matriculation matriculation = new Matriculation();
        matriculation.setId(id);
        matriculation.setIdStudent(123);

        return matriculation;
    }

    @Override
    public boolean insert(Models model) {
        Student student = (Student) model;
        return true;
    }

    public List<Matriculation> selectByIdStudent(Integer idStudent) {
        List<Matriculation> matriculations = new ArrayList<Matriculation>();

        for(Integer i=0;i<100;i++) {
            Matriculation matriculation = new Matriculation();
            matriculation.setId(i);
            matriculation.setIdStudent(i);
            matriculations.add(matriculation);
        }


        return matriculations;
    }
}
