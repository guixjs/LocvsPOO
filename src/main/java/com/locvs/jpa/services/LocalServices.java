package com.locvs.jpa.services;

import com.locvs.jpa.controller.LocalController;
import com.locvs.jpa.models.servicos.LocalModel;
import com.locvs.jpa.models.usuarios.PfModel;
import com.locvs.jpa.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LocalServices {
    @Autowired
    LocalRepository localRepository;

    public void salvarLocal(String endereco, String logradouro, String bairro, String municipio, int cep, String tipoLocal, String nomeLocal){
        LocalModel local = new LocalModel();
        local.setEndereco(endereco);
        local.setLogradouro(logradouro);
        local.setBairro(bairro);
        local.setMunicipio(municipio);
        local.setCEP(cep);
        local.setTipoLocal(tipoLocal);
        local.setNomeLocal(nomeLocal);
        localRepository.save(local);
    }
    public void listarLocais() {
        List<LocalModel> locais = localRepository.findAll();
        locais.forEach(local -> System.out.println("Nome do local: "+local.getNomeLocal()+
                "\nTipo do local: "+local.getTipoLocal()+
                "\n Endereço: "+local.getEndereco()+
                "\nLogradouro: "+local.getLogradouro()+
                "\nMunicipio: "+ local.getMunicipio()+
                "\nBairro: "+local.getBairro()));
        System.out.println("===========");
    }
}
