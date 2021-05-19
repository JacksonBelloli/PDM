package com.example.academia.model;

import java.util.HashMap;

public class Matriculation extends Models {

    Integer id;
    Integer idStudent;
    Integer idPlan;
    Integer idModality;
    private  Integer idGraduation;
    String data_matricula;
    Integer vencimento;
    String encerramento;

    @Override
    public HashMap<String, String> getElements() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("Aluno", idStudent.toString());
        if(idPlan != null) {
            elements.put("Plano", idPlan.toString());
        }
        else {
            elements.put("Plano", "");
        }
        if(idModality != null) {
            elements.put("Modalidade", idModality.toString());
        }
        else {
            elements.put("Modalidade", "");
        }


        elements.put("Matricula", data_matricula);
        if(vencimento == null) {
            elements.put("Vencimento", "");
        }
        else {
            elements.put("Vencimento", vencimento.toString());
        }
        elements.put("Encerramento", encerramento);
        return elements;
    }

    @Override
    public String getMain() {
        return id.toString() + " - " + idStudent;
    }

    @Override
    public HashMap<String, String> getFields() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("modality", "Spinner");
        elements.put("data_matricula", "String");
        elements.put("vencimento", "Integer");
        elements.put("encerramento", "String");
        return elements;
    }

    public void setByKey(String key, String value) {
        System.out.println("SetByKey: " + key + "{" + value + "}");
        switch (key) {
            case "data_matricula":
                if(value != null &&  !value.equals("")) {
                    this.data_matricula = value;
                }
                return;
            case "modality":
                if(value != null &&  !value.equals("")) {
                    String[] ss = value.split("|");
                    this.idModality = Integer.parseInt(ss[0]);
                }
                return;
            case "vencimento":
                if(value != null &&  !value.equals("")) {
                    this.vencimento = Integer.parseInt(value);
                }
                return;
            case "encerramento":
                if(value != null &&  !value.equals("")) {
                    this.encerramento = value;
                }
                return;
        }
    }

    public Matriculation() {
    }

    public Matriculation(Integer id, Integer idStudent, Integer idPlan, Integer idModality, String data_matricula, Integer vencimento, String encerramento) {
        this.id = id;
        this.idStudent = idStudent;
        this.idPlan = idPlan;
        this.idModality = idModality;
        this.data_matricula = data_matricula;
        this.vencimento = vencimento;
        this.encerramento = encerramento;
    }

    public Integer getIdGraduation() {
        return idGraduation;
    }

    public void setIdGraduation(Integer idGraduation) {
        this.idGraduation = idGraduation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdModality() {
        return idModality;
    }

    public void setIdModality(Integer idModality) {
        this.idModality = idModality;
    }

    public String getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }

    public Integer getVencimento() {
        return vencimento;
    }

    public void setVencimento(Integer vencimento) {
        this.vencimento = vencimento;
    }

    public String getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(String encerramento) {
        this.encerramento = encerramento;
    }
}
