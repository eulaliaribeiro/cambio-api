package com.ada.deva.cotacao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Deverá ser criada uma API para calcular a cotação da moeda,
 * a qual deve chamar a API externa https://economia.awesomeapi.com.br/
 * informando a sigla da moeda desejada (https://economia.awesomeapi.com.br/USD/ ou https://economia.awesomeapi.com.br/EUR/).
 * Se o cliente tentar comprar outra moeda que não USD ou EUR, deverá ser lançada uma exceção.
 * **/

@Data
public class Cotacao {
    private String tipo_moeda;
    private BigDecimal valor_cotacao;
    private LocalDateTime dataSolicitacao;

    public Cotacao(String tipo_moeda, BigDecimal valor_cotacao, LocalDateTime dataSolicitacao) {
        this.tipo_moeda = tipo_moeda;
        this.valor_cotacao = valor_cotacao;
        this.dataSolicitacao = dataSolicitacao;

    }
}