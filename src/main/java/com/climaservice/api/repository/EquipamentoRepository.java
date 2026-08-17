package com.climaservice.api.repository;

import com.climaservice.api.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByClienteId(Long clienteId);
}