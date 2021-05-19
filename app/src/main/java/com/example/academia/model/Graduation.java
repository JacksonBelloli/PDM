package com.example.academia.model;

import java.util.HashMap;

public class Graduation extends Models {

    Integer id;
    Integer idModality;
    String nome;


    @Override
    public HashMap<String, String> getElements() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("Nome", nome);
        if(idModality != null) {
            elements.put("Modalidade", idModality.toString());
        }
        else {
            elements.put("Modalidade", "");
        }

        return elements;
    }

    @Override
    public String getMain() {
        return nome;
    }

    @Override
    public HashMap<String, String> getFields() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("nome", "String");
        return elements;
    }

    public void setByKey(String key, String value) {
        System.out.println("SetByKey: " + key + "{" + value + "}");
        switch (key) {
            case "nome":
                this.nome = value;
                return;
        }
    }

    @Override
    public String toString() {
        return "Graduation{" +
                "id=" + id +
                ", idModality=" + idModality +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Graduation() {
    }


    public Graduation(Integer id, Integer idModality, String modalidade, String nome) {
        this.id = id;
        this.idModality = idModality;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdModality() {
        return idModality;
    }

    public void setIdModality(Integer idModality) {
        this.idModality = idModality;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
