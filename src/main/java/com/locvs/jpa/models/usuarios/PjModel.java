package com.locvs.jpa.models.usuarios;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.locvs.jpa.models.servicos.LocalModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PJ")
public class PjModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String CNPJ;
    @Column(nullable = false)
    private String RazaoSocial;
    @Column(nullable = false,unique = true)
    private String NomeFantasia;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "pj",fetch = FetchType.LAZY)
    private Set<LocalModel> locais = new HashSet<>();

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return NomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        NomeFantasia = nomeFantasia;
    }

    public Set<LocalModel> getLocais() {
        return locais;
    }

    public void setLocais(Set<LocalModel> locais) {
        this.locais = locais;
    }
}
