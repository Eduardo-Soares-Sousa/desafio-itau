package com.itau.apiRest.model;

public record Estatisticas(
        Double count,
        Double sum,
        Double avg,
        Double min,
        Double max) {
}
