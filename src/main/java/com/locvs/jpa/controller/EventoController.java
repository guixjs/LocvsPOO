package com.locvs.jpa.controller;

import com.locvs.jpa.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

@Component
public class EventoController {
    @Autowired
    private EventoService eventoService;

    public void CapturarDadosEventos(){
        Scanner sc = new Scanner(System.in);
        String tituloEventoTemp;
        String descricaoTemp;
        String dataTemp;
        String horarioTemp;

        System.out.println("Digite o nome do evento: ");
        tituloEventoTemp = sc.nextLine();

        System.out.println("Descrição do evento: ");
        descricaoTemp = sc.nextLine();

        System.out.println("Data do evento: ");
        dataTemp = sc.nextLine();

        System.out.println("Horário que vai ocorrer: ");
        horarioTemp = sc.nextLine();

        eventoService.salvarEvento(tituloEventoTemp,descricaoTemp,dataTemp,horarioTemp);
    }
    @GetMapping("/eventos")
    public void ListarEventos(){
        eventoService.ListarEventos();
    }
}
