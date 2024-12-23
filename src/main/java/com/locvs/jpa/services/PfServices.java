package com.locvs.jpa.services;

import com.locvs.jpa.models.usuarios.PfModel;
import com.locvs.jpa.repositories.PfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PfServices {

    @Autowired
    private PfRepository pfRepository;

    public void salvarPF(String cpf, String nome, String nascimento, char sexo) {
        PfModel pf = new PfModel();
        pf.setCPF(cpf);
        pf.setNome(nome);
        pf.setNascimento(nascimento);
        pf.setSexo(sexo);
        pfRepository.save(pf);
    }

    public void listarPF() {
        List<PfModel> pfs = pfRepository.findAll();
        pfs.forEach(pf -> System.out.println("CPF: " + pf.getCPF() +
                "\nNome: " + pf.getNome() +
                "\nNascimento: " + pf.getNascimento() +
                "\nSexo: " + pf.getSexo()));
        System.out.println("===========");
    }

    public void deletarPF(String cpf) {
        pfRepository.deleteById(cpf);
        System.out.println("PF com CPF " + cpf + " deletado com sucesso.");
    }

    public String realizarLogin(String cpf) {
        PfModel pf = pfRepository.findById(cpf).orElse(null);
        if (pf != null) {
            return "Bem-vindo, " + pf.getNome();
        } else {
            return "CPF não encontrado.";
        }
    }

}
