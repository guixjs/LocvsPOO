package com.locvs.jpa.repositories;

import com.locvs.jpa.models.usuarios.PjModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PjRepository extends JpaRepository<PjModel,String> {
}
