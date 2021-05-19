package com.example.academia.model;

import java.util.HashMap;

public class Modality extends Models {
    private Integer id;
    private String nome;

    public Modality() {

    }

    @Override
    public HashMap<String, String> getElements() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("Nome", nome);
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

    public Modality(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setByKey(String key, String value) {
        System.out.println("SetByKey: " + key + "{" + value + "}");
        switch (key) {
            case "nome":
                this.nome = value;
                return;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
