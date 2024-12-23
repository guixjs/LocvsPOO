package com.locvs.jpa.repositories;

import com.locvs.jpa.models.usuarios.PfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PfRepository extends JpaRepository<PfModel, String> {
}
