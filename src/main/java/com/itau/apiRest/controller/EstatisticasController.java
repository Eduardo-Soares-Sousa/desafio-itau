package com.itau.apiRest.controller;

import com.itau.apiRest.model.Estatisticas;
import com.itau.apiRest.service.EstatisticasService;
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
    public ResponseEntity<Estatisticas> calcularEstatisticas() {
        return ResponseEntity.ok(estatisticasService.calcularEstatisticas());
    }
}
