package com.climaservice.api.controller;

import com.climaservice.api.dto.EquipamentoRequestDTO;
import com.climaservice.api.dto.EquipamentoResponseDTO;
import com.climaservice.api.service.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/equipamentos")
    public ResponseEntity<EquipamentoResponseDTO> salvar(
            @Valid @RequestBody EquipamentoRequestDTO dto) {

        EquipamentoResponseDTO equipamento =
                equipamentoService.salvar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipamento);
    }

    @GetMapping("/equipamentos")
    public List<EquipamentoResponseDTO> listarTodos() {
        return equipamentoService.listarTodos();
    }

    @GetMapping("/equipamentos/{id}")
    public ResponseEntity<EquipamentoResponseDTO> buscarPorId(
            @PathVariable Long id) {

        return equipamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/equipamentos/{id}")
    public ResponseEntity<EquipamentoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EquipamentoRequestDTO dto) {

        return equipamentoService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/equipamentos/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        if (equipamentoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        equipamentoService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientes/{clienteId}/equipamentos")
    public List<EquipamentoResponseDTO> listarPorCliente(
            @PathVariable Long clienteId) {

        return equipamentoService.listarPorCliente(clienteId);
    }
}