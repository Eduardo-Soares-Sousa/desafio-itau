package com.itau.apiRest.controller;

import com.itau.apiRest.model.Estatisticas;
import com.itau.apiRest.service.EstatisticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estatisticas")
public class EstatisticasController {
    private EstatisticasService estatisticasService;

    @GetMapping
    @Operation(description = "Endpoint responsável por calcular os dados das estatísticas")
    @ApiResponse(responseCode = "200", description = "Cálculos das estatísticas efetuadas com sucesso")
    public ResponseEntity<Estatisticas> calcularEstatisticas() {
        return ResponseEntity.ok(estatisticasService.calcularEstatisticas());
    }
}
