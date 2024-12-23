package com.locvs.jpa.repositories;

import com.locvs.jpa.models.servicos.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventoRepository extends JpaRepository<EventoModel, UUID> {
}
