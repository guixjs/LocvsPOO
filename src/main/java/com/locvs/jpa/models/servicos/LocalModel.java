package com.locvs.jpa.models.servicos;

import com.locvs.jpa.models.usuarios.PjModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Local")
public class LocalModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLocal;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String municipio;
    @Column(nullable = false)
    private int CEP;
    @Column(nullable = false)
    private String tipoLocal;
    @Column(nullable = false)
    private String nomeLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pj_CNPJ")
    private PjModel pj;

    @ManyToMany(mappedBy = "local",fetch = FetchType.LAZY)
    private Set<EventoModel> eventos = new HashSet<>();

    public UUID getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(UUID idLocal) {
        this.idLocal = idLocal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public PjModel getPj() {
        return pj;
    }

    public void setPj(PjModel pj) {
        this.pj = pj;
    }

    public Set<EventoModel> getEventos() {
        return eventos;
    }

    public void setEventos(Set<EventoModel> eventos) {
        this.eventos = eventos;
    }
}
