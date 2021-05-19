package com.example.academia.model;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student extends Models {
    private Integer id;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String telefone;
    private String celular;
    private String email;
    private String observacao;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public Student() {

    }

    @Override
    public String getMain() {
        return nome;
    }

    @Override
    public HashMap<String, String> getElements() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("data_nascimento", data_nascimento);
        elements.put("sexo", sexo);
        elements.put("telefone", telefone);
        elements.put("celular", celular);
        elements.put("email", email);
        elements.put("observacao", observacao);
        elements.put("endereco", endereco);
        if(numero == null) {
            elements.put("numero", "");
        }
        else {
            elements.put("numero", numero.toString());
        }

        elements.put("complemento", complemento);
        elements.put("bairro", bairro);
        elements.put("cidade", cidade);
        elements.put("estado", estado);
        elements.put("pais", pais);
        elements.put("cep", cep);

        return elements;
    }

    public Student(Integer id, String nome, String data_nascimento,
                   String sexo, String telefone, String celular, String email,
                   String observacao, String endereco, Integer numero, String complemento,
                   String bairro, String cidade, String estado, String pais, String cep) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.observacao = observacao;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public List<String> spinnerSexo() {
        List<String> sexos = new ArrayList<String>();
        sexos.add("Masculino");
        sexos.add("Feminino");

        return sexos;
    }

    public HashMap<String, String> getFields() {
        HashMap<String, String> elements = new HashMap<String, String>();
        elements.put("nome", "String");
        elements.put("Data Nascimento", "Date");
        elements.put("Sexo", "Spinner");
        elements.put("telefone", "Phone");
        elements.put("celular", "Phone");
        elements.put("email", "Email");
        elements.put("observacao", "String");
        elements.put("endereco", "String");
        elements.put("numero", "Integer");
        elements.put("complemento", "String");
        elements.put("bairro", "String");
        elements.put("cidade", "String");
        elements.put("estado", "String");
        elements.put("pais", "String");
        elements.put("cep", "Integer");

        return elements;
    }

    public void setByKey(String key, String value) {
        System.out.println("SetByKey: " + key + "{" + value + "}");
        switch (key) {
            case "nome":
                this.nome = value;
                return;
            case "Data Nascimento":
                this.data_nascimento = value;
                return;
            case "Sexo":
                this.sexo = value;
                return;
            case "telefone":
                this.telefone = value;
                return;
            case "celular":
                this.celular = value;
                return;
            case "email":
                this.email = value;
                return;
            case "observacao":
                this.observacao = value;
                return;
            case "endereco":
                this.endereco = value;
                return;
            case "numero":
                if(value != null &&  !value.equals("")) {
                    this.numero = Integer.parseInt(value);
                }
                return;
            case "complemento":
                this.complemento = value;
                return;
            case "bairro":
                this.bairro = value;
                return;
            case "cidade":
                this.cidade = value;
                return;
            case "estado":
                this.estado = value;
                return;
            case "pais":
                this.pais = value;
                return;
            case "cep":
                this.cep = value;
                return;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", observacao='" + observacao + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", cep='" + cep + '\'' +
                '}';
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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


}
