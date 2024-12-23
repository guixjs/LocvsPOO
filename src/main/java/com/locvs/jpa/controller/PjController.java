package com.locvs.jpa.controller;


import com.locvs.jpa.services.PjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Scanner;


@Component
public class PjController {

    @Autowired
    private PjService pjServices;

    public void capturaDosDadosConsole() {
        Scanner sc = new Scanner(System.in);
        String cnpjTemp;
        String nomeFantTemp;
        String razaoSocTemp;

        System.out.println("Digite o CNPJ da empresa: ");
        cnpjTemp = sc.nextLine();
        while (cnpjTemp.length() != 14) {
            System.out.println("Tamanho de CNPJ incorreto, digite novamente:  ");
            cnpjTemp = sc.nextLine();
        }
        System.out.println("Digite o nome fantasia da empresa: ");
        nomeFantTemp = sc.nextLine();

        System.out.println("Digite a razão social: ");
        razaoSocTemp = sc.nextLine();

        pjServices.salvarPJ(cnpjTemp, nomeFantTemp, razaoSocTemp);
        System.out.println("Dados enviados ao banco de dados.");
    }

    @GetMapping("/pj")
    public void listarPjs() {
        pjServices.listarPJ();
    }

    @DeleteMapping("/pj/{cnpj}")
    public void deletarPj(@PathVariable String cnpj) {
        pjServices.deletarPF(cnpj); // Chama o método deletarPF do serviço
    }

    // Endpoint para login usando o CPF
    @GetMapping("/login")
    public String realizarLogin(@RequestParam String cnpj) {
        return pjServices.realizarLogin(cnpj); // Chama o método realizarLogin do serviço
    }
}
