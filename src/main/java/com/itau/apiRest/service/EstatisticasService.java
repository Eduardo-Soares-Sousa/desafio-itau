package com.itau.apiRest.service;

import com.itau.apiRest.model.Estatisticas;
import com.itau.apiRest.model.Transacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {
    private final TransacaoService transacaoService;

    public Estatisticas calcularEstatisticas() {
        List<Transacao> transacaoList = transacaoService.buscarUltimasTransacoes();

        DoubleSummaryStatistics estatisticas = transacaoList.stream()
                .mapToDouble(Transacao::getValor).summaryStatistics();

        return new Estatisticas((double) estatisticas.getCount(),
                estatisticas.getSum(), estatisticas.getAverage(), estatisticas.getMin(), estatisticas.getMax());
    }
}
