package com.climaservice.api.dto;

public record EquipamentoResponseDTO(

        Long id,
        String marca,
        String modelo,
        Integer capacidadeBtu,
        String numeroSerie,
        String localInstalacao,
        Long clienteId,
        String clienteNome

) {
}