package com.locvs.jpa.controller;

import com.locvs.jpa.services.LocalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

@Component
public class LocalController {

    @Autowired
    private LocalServices localServices;

    public void capturarDadosLocal(){
        Scanner sc = new Scanner(System.in);
        String enderecoTemp;
        String logradouroTemp;
        String bairroTemp;
        String municipioTemp;
        int CEP;
        String tipoLocalTemp;
        String nomeLocalTemp;

        System.out.println("Digite o nome do Estabelecimento: ");
        nomeLocalTemp = sc.nextLine();

        System.out.println("Digite o endereço do Estabelecimento: ");
        enderecoTemp = sc.nextLine();

        System.out.println("Logradouro: ");
        logradouroTemp = sc.nextLine();

        System.out.println("Bairro:");
        bairroTemp = sc.nextLine();

        System.out.println("municipio:");
        municipioTemp = sc.nextLine();

        System.out.println("tipo do local:");
        tipoLocalTemp = sc.nextLine();
        System.out.println("cep");
        CEP = sc.nextInt();

        localServices.salvarLocal(enderecoTemp,logradouroTemp,bairroTemp,municipioTemp,CEP,tipoLocalTemp,nomeLocalTemp);
    }
    @GetMapping("/locais")
    public void listarLocais(){
        localServices.listarLocais();
    }
}
