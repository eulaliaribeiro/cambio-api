package com.ada.deva.cotacao;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CotacaoDTO {

    private String code;
    private String codein;
    private String name;
    private Double high;
    private Double low;
    private Double varBid;
    private Double pctChange;
    private BigDecimal bid;
    private BigDecimal ask;
    private String timestamp;
    private String create_date;

}
