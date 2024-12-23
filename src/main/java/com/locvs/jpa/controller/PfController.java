package com.locvs.jpa.controller;

import com.locvs.jpa.models.usuarios.PfModel;
import com.locvs.jpa.repositories.PfRepository;
import com.locvs.jpa.services.PfServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Scanner;

@Component
public class PfController {

    @Autowired
    private PfServices pfServices;
    @Autowired
    private PfRepository pfRepository;

    public void capturarDadosDoConsole() {
        Scanner sc = new Scanner(System.in);

        String nomeTemp;
        String cpfTemp;
        String nascTemp;
        char sexoTemp;


        System.out.println("Digite seu nome: ");
        nomeTemp = sc.nextLine();


        System.out.println("Digite seu CPF (sem pontos e traço): ");
        cpfTemp = sc.nextLine();
        while (cpfTemp.length() != 11) {
                System.out.println("Tamanho incorreto, digite novamente");
                System.out.println("Digite seu CPF (sem pontos e traço): ");
                cpfTemp = sc.nextLine();
        }

        System.out.println("Digite sua data de nascimento (formato dd/mm/aaaa): ");
        nascTemp = sc.nextLine();
        while (nascTemp.length() != 10) {
            System.out.println("Tamanho incorreto de data, digite no formato dd/mm/aaaa");
            System.out.println("Digite sua data de nascimento: ");
            nascTemp = sc.nextLine();
        }


        System.out.println("Digite seu sexo: ");
        sexoTemp = sc.nextLine().toUpperCase().charAt(0);
        while (sexoTemp != 'F' && sexoTemp != 'M') {
            System.out.println("Digite um sexo válido: ");
            sexoTemp = sc.nextLine().toUpperCase().charAt(0);
        }


        pfServices.salvarPF(cpfTemp, nomeTemp, nascTemp, sexoTemp);
        System.out.println("Dados enviados ao banco de dados.");
    }

    // Endpoint para listar todos os PFs
    @GetMapping("/pf")
    public void listarPfs() {
        pfServices.listarPF(); // Chama o método listarPF do serviço
    }

    @DeleteMapping("/pf/{cpf}")
    public void deletarPf(@PathVariable String cpf) {
        pfServices.deletarPF(cpf); // Chama o método deletarPF do serviço
    }

    // Endpoint para login usando o CPF
    @GetMapping("/login")
    public String realizarLogin(@RequestParam String cpf) {
        return pfServices.realizarLogin(cpf); // Chama o método realizarLogin do serviço
    }
}
