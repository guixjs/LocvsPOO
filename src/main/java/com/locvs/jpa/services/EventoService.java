package com.locvs.jpa.services;

import com.locvs.jpa.models.servicos.EventoModel;
import com.locvs.jpa.models.servicos.LocalModel;
import com.locvs.jpa.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public void salvarEvento(String tituloEventoTemp,String descricaoTemp, String dataTemp,String horarioTemp){
        EventoModel evento = new EventoModel();

        evento.setTituloEvento(tituloEventoTemp);
        evento.setDescricao(descricaoTemp);
        evento.setData(dataTemp);
        evento.setHorario(horarioTemp);

        eventoRepository.save(evento);
    }

    public void ListarEventos() {
        List<EventoModel> eventos = eventoRepository.findAll();
        eventos.forEach(evento -> System.out.println("Titulo do evento: "+ evento.getTituloEvento()+
                "\nDescrição do evento: "+evento.getDescricao()+
                "\nData do evento: "+evento.getData()+
                "\nHorário do evento: "+evento.getHorario()+
                "\nLocal: "+evento.getLocal()));
        System.out.println("===========");
    }
}
