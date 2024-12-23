package com.locvs.jpa.models.usuarios;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.locvs.jpa.models.servicos.EventoModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PF")
public class PfModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String CPF;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String nascimento;
    @Column(nullable = false)
    private char sexo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "pf",fetch = FetchType.LAZY)
    private Set<EventoModel> eventos = new HashSet<>();

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Set<EventoModel> getEventos() {
        return eventos;
    }

    public void setEventos(Set<EventoModel> eventos) {
        this.eventos = eventos;
    }
}
