package com.itau.apiRest.service;

import com.itau.apiRest.model.Estatisticas;
import com.itau.apiRest.model.Transacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {
    private final TransacaoService transacaoService;

    public Estatisticas calcularEstatisticas() {
        log.info("Iniciando processo de calcular estatísticas");
        List<Transacao> transacaoList = transacaoService.buscarUltimasTransacoes();

        log.info("Calculando e mapeando valores para Double");
        DoubleSummaryStatistics estatisticas = transacaoList.stream()
                .mapToDouble(Transacao::getValor).summaryStatistics();

        log.info("Retorno dos dados das estatísticas dos últimos 60 segundos");
        return new Estatisticas((double) estatisticas.getCount(),
                estatisticas.getSum(), estatisticas.getAverage(), estatisticas.getMin(), estatisticas.getMax());
    }
}
