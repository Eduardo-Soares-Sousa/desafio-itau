package com.itau.apiRest.service;

import com.itau.apiRest.exceptions.UnprocessableException;
import com.itau.apiRest.model.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransacaoService {
    private List<Transacao> listaTransacoes = new ArrayList<>();

    public void salvaTransacao(Transacao transacao) {
        log.info("Iniciando o processo de transação");
        if(transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            log.error("Transações não podem ocorrer no futuro");
            throw new UnprocessableException("A data da transação não pode ocorrer no futuro.");
        }else if(transacao.getValor() < 0) {
            log.error("O valor da transação menor que 0");
            throw new UnprocessableException("O valor não pode ser menor que 0.");
        }

        log.info("Transação adicionada com sucesso");
        listaTransacoes.add(transacao);
    }

    public void deletarTransacoes() {
        log.info("Iniciando o processo de exclusão das transações");
        listaTransacoes.clear();
        log.info("Transações apagadas com sucesso");
    }

    public List<Transacao> buscarUltimasTransacoes() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
        log.info("Retornando transações feitas nos últimos 60 segundos");
        return listaTransacoes.stream()
                .filter(transacao -> transacao.getDataHora()
                        .isAfter(limite)).toList();
    }
}
