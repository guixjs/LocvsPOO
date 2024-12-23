package com.locvs.jpa.services;

import com.locvs.jpa.models.usuarios.PfModel;
import com.locvs.jpa.models.usuarios.PjModel;
import com.locvs.jpa.repositories.PjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PjService {
    @Autowired
    PjRepository pjRepository;

    public void salvarPJ(String cnpj, String nomeFantasia, String razaoSocial){
        PjModel pj = new PjModel();

        pj.setCNPJ(cnpj);
        pj.setNomeFantasia(nomeFantasia);
        pj.setRazaoSocial(razaoSocial);

        pjRepository.save(pj);
    }

    public void listarPJ() {
        List<PjModel> pjs = pjRepository.findAll();
        pjs.forEach(pj -> System.out.println("CNPJ: " + pj.getCNPJ() +
                "\nNome Fantasia: " + pj.getNomeFantasia() +
                "\nRazão Social: " +pj.getRazaoSocial()));
        System.out.println("===========");
    }

    public void deletarPF(String cnpj) {
        pjRepository.deleteById(cnpj);
        System.out.println("PJ com CNPJ " + cnpj + " deletado com sucesso.");
    }

    public String realizarLogin(String cnpj) {
        PjModel pj = pjRepository.findById(cnpj).orElse(null);
        if (pj != null) {
            return "Bem-vindo, " + pj.getRazaoSocial();
        } else {
            return "CPF não encontrado.";
        }
    }
}
