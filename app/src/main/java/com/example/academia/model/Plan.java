package com.example.academia.model;

import java.util.HashMap;

public class Plan extends Models {
    private Integer id;
    private Integer idModality;
    private String nome;
    private Double mensalidade;

    public Plan() {

    }

    public Plan(Integer id, Integer idModality, String nome, Double mensalidade) {
        this.id = id;
        this.idModality = idModality;
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

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

        if(mensalidade == null) {
            elements.put("Mensalidade", "0,00");

        }
        else {
            elements.put("Mensalidade", mensalidade.toString());
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
        elements.put("mensalidade", "Double");

        return elements;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer idModality() {
        return idModality;
    }

    public void setIdModality(Integer idModality) {
        this.idModality = idModality;
    }

    public void setByKey(String key, String value) {
        System.out.println("SetByKey: " + key + "{" + value + "}");
        switch (key) {
            case "nome":
                this.nome = value;
                return;
            case "mensalidade":
                if(value != null &&  !value.equals("")) {
                    this.mensalidade = Double.parseDouble(value);
                }

                return;
        }
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", idModality=" + idModality +
                ", nome='" + nome + '\'' +
                ", mensalidade=" + mensalidade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
