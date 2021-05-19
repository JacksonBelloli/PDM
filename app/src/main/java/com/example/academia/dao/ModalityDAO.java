package com.example.academia.dao;

import com.example.academia.model.Modality;
import com.example.academia.model.Models;
import com.example.academia.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ModalityDAO  extends DAO {

    public List<Modality> selectAll() {
        List<Modality> modalities = new ArrayList<Modality>();

        for(Integer i=0;i<100;i++) {
            Modality modality = new Modality();
            modality.setId(i);
            modality.setNome("Modality  " + i.toString());
            modalities.add(modality);
        }


        return modalities;
    }

    public Modality selectById(Integer id) {
        Modality student = new Modality();
        student.setId(id);
        student.setNome("Modality " + id.toString());

        return student;
    }

    @Override
    public boolean insert(Models model) {
        Modality modality = (Modality) model;
        return true;
    }
}
