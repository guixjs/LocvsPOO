package com.locvs.jpa.repositories;

import com.locvs.jpa.models.servicos.LocalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocalRepository extends JpaRepository <LocalModel, UUID> {
}
