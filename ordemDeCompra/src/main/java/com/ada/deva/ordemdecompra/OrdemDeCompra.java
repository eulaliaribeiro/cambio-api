package com.ada.deva.ordemdecompra;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class OrdemDeCompra {
    @Id
    @GeneratedValue
    private Long id;

    private String id_cliente;

    private String cpf_cliente;

    private String tipo_moeda;

    private Double valor_moeda_estrangeira;

    private Double valor_cotacao;
    private Double valor_total_operacao;
    private LocalDateTime dataSolicitacao;
    private String conta;

}
