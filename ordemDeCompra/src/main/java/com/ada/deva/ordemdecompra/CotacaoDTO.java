package com.ada.deva.ordemdecompra;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class CotacaoDTO {

    private String code;
    private String codein;
    private String name;
    private Double high;
    private Double low;
    private Double varBid;
    private Double pctChange;
    private Double bid;
    private BigDecimal ask;
    private String timestamp;
    private String create_date;

}
