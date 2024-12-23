package com.locvs.jpa;

import com.locvs.jpa.controller.LocalController;
import com.locvs.jpa.controller.PjController;
import com.locvs.jpa.controller.PfController;
import com.locvs.jpa.view.MenuLogado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

		MenuLogado menu = new MenuLogado();
		PfController pfController = context.getBean(PfController.class);
		PjController pjController = context.getBean(PjController.class);
		String dadoVerificador;
		int escolha,tipo;
		do{
			System.out.println("====================");
			System.out.println("MENU DE OPÇÕES");
			System.out.println("====================");
			System.out.println("1 - Registar");
			System.out.println("2 - Login");
			System.out.println("3 - Sair");
			System.out.print("DIGITE A OPÇÃO QUE DESEJA REALIZAR: ");
			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha){
				case 1:
					System.out.println("======================");
					System.out.println("TELA DE REGISTRO");
					System.out.println("======================");
					System.out.println("1 - Pessoa Física");
					System.out.println("2 - Pessoa Jurídica");
					System.out.println("3 - Sair");
					System.out.println("Qual tipo de usuário você deseja registrar: ");
					tipo = sc.nextInt();
					while (tipo<1 || tipo>3){
						System.out.println("Opção invalida, tente novamente");
						System.out.println("Qual tipo de usuário você deseja registrar: ");
						tipo = sc.nextInt();
					}
					if(tipo ==1){
						pfController.capturarDadosDoConsole();
					}else if(tipo == 2) {
						pjController.capturaDosDadosConsole();
					}else{
						break;
					}
					break;
				case 2:
					System.out.println("======================");
					System.out.println("TELA DE LOGIN");
					System.out.println("======================");
					System.out.println("DIGITE SEU CPF ou CNPJ");
					dadoVerificador = sc.nextLine();
					if(dadoVerificador.length() ==11){
						String mensagem = pfController.realizarLogin(dadoVerificador);
						System.out.println(mensagem);
						menu.MenuLogadoPF();

					} else if (dadoVerificador.length() ==14) {
						String mensagem = pjController.realizarLogin(dadoVerificador);
						System.out.println(mensagem);
						menu.MenuLogadoPJ();
					}else{
						System.out.println("Dados inválidos, tente novamente");
						break;
					}
					break;
				case 3:
					System.out.println("Encerrando...");
					break;
				default:
					System.out.println("Digite uma opção válida");
			}
		}while (escolha !=3);
		System.out.println("Obrigador por utilizar o sistema de cadastramento do locvs!");
	}

}
