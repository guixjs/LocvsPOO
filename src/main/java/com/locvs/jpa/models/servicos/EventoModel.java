package com.locvs.jpa.models.servicos;

import com.locvs.jpa.models.usuarios.PfModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Evento")
public class EventoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEvento;
    @Column(nullable = false)
    private String tituloEvento;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String data;
    @Column(nullable = false)
    private String horario;

    @ManyToMany
    @JoinTable(name = "Pf_Participa_Evento",
    joinColumns = @JoinColumn(name = "id_Evento"),
    inverseJoinColumns = @JoinColumn(name = "pf_CPF"))
    private Set<PfModel> pf = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Local_Sedia_Evento",
            joinColumns = @JoinColumn(name = "id_Evento"),
            inverseJoinColumns = @JoinColumn(name = "id_Local"))
    private Set<LocalModel> local = new HashSet<>();

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Set<PfModel> getPf() {
        return pf;
    }

    public void setPf(Set<PfModel> pf) {
        this.pf = pf;
    }

    public Set<LocalModel> getLocal() {
        return local;
    }

    public void setLocal(Set<LocalModel> local) {
        this.local = local;
    }
}
