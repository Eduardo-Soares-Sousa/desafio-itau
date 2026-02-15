package com.itau.apiRest.controller;

import com.itau.apiRest.model.Transacao;
import com.itau.apiRest.service.TransacaoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "A transação foi aceita")
    @ApiResponse(responseCode = "422", description = "Transação não foi aceita - os campos não atendem os requisitos")
    @ApiResponse(responseCode = "400", description = "Erro de requisição")
    public ResponseEntity<Void> salvarTransacao(@RequestBody Transacao transacao) {
        transacaoService.salvaTransacao(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @ApiResponse(responseCode = "200", description = "Transações deletadas com sucesso")
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.deletarTransacoes();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
