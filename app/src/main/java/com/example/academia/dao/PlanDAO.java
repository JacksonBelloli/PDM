package com.example.academia.dao;

import com.example.academia.model.Modality;
import com.example.academia.model.Models;
import com.example.academia.model.Plan;
import com.example.academia.model.Student;

import java.util.ArrayList;
import java.util.List;

public class PlanDAO extends DAO {

    public List<Plan> selectAll() {
        List<Plan> plans = new ArrayList<Plan>();

        for(Integer i=0;i<100;i++) {
            Plan plan = new Plan();
            plan.setId(i);
            plan.setNome("Plano " + i.toString());
            plans.add(plan);
        }


        return plans;
    }

    public Plan selectById(Integer id) {
        Plan plan = new Plan();
        plan.setId(id);
        plan.setNome("Plano " + id.toString());

        return plan;
    }

    @Override
    public boolean insert(Models model) {
        Plan student = (Plan) model;
        return true;
    }

    public List<Plan> selectByIdModality(Integer idModality) {
        List<Plan> plans = new ArrayList<Plan>();

        for(Integer i=0;i<100;i++) {
            Plan plan = new Plan();
            plan.setId(i);
            plan.setNome("Plano " + i.toString());
            plans.add(plan);
        }

        return plans;
    }
}
