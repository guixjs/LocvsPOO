package com.locvs.jpa.view;

import com.locvs.jpa.controller.EventoController;
import com.locvs.jpa.controller.LocalController;
import jakarta.persistence.SharedCacheMode;
import org.springframework.cglib.core.Local;

import java.util.List;
import java.util.Scanner;

public class MenuLogado {

    public void MenuLogadoPF() {
        LocalController localController = new LocalController();
        EventoController eventoController = new EventoController();
        Scanner sc = new Scanner(System.in);
        int escolhaPF;
        System.out.println("===============================");
        System.out.println("Usuário logado com sucesso!");
        System.out.println("===============================");
        System.out.println("O que deseja fazer?");
        do {
            System.out.println("1. Listar locais");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Sair");
            escolhaPF = sc.nextInt();
            sc.nextLine();

            switch (escolhaPF) {
                case 1:
                    System.out.println("Listar locais");
                    localController.listarLocais();
                    break;
                case 2:
                    System.out.println("Listar Eventos");
                    eventoController.ListarEventos();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma oção válida");
                    break;
            }

        } while (escolhaPF != 5);
    }

    public void MenuLogadoPJ(){
        LocalController localController = new LocalController();
        EventoController eventoController = new EventoController();
        Scanner sc = new Scanner(System.in);
        int escolhaPJ;
        System.out.println("===============================");
        System.out.println("Usuário logado com sucesso!");
        System.out.println("===============================");
        System.out.println("O que deseja fazer?");
        do {
            System.out.println("1 - Cadastrar Local");
            System.out.println("2 - Cadastrar Evento");
            System.out.println("3 - Sair");
            escolhaPJ = sc.nextInt();
            sc.nextLine();

            switch (escolhaPJ) {
                case 1:
                    System.out.println("Cadastrar Local");
                    localController.capturarDadosLocal();
                    break;
                case 2:
                    System.out.println("Cadastrar Evento");
                    eventoController.CapturarDadosEventos();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                   System.out.println("Digite uma oção válida");
                    break;
            }

        }while(escolhaPJ!=3);
    }
}
