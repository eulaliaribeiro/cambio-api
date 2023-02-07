package com.ada.deva.ordemdecompra;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class CotacaoDTO {

    private String tipo_moeda;
    private Double valor_cotacao;
    private LocalDateTime dataSolicitacao;

}
