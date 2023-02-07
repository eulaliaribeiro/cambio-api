package com.ada.deva.ordemdecompra;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OrdemDeCompraDTO {
    private Long id_compra;
    private String id_cliente;
    private String cpf_cliente;
    private String tipo_moeda;
    private Double valor_moeda_estrangeira;
    private Double valor_cotacao;
    private Double valor_total_operacao;
    private LocalDateTime dataSolicitacao;
    private String conta;

    public static OrdemDeCompraDTO of(OrdemDeCompra ordemDeCompra){
        OrdemDeCompraDTO dto = new OrdemDeCompraDTO();
        dto.setId_compra(ordemDeCompra.getId());
        dto.setId_cliente(ordemDeCompra.getId_cliente());
        dto.setCpf_cliente(ordemDeCompra.getCpf_cliente());
        dto.setDataSolicitacao(ordemDeCompra.getDataSolicitacao());
        dto.setTipo_moeda(ordemDeCompra.getTipo_moeda());
        dto.setValor_cotacao(ordemDeCompra.getValor_cotacao());
        dto.setValor_moeda_estrangeira(ordemDeCompra.getValor_moeda_estrangeira());
        dto.setValor_total_operacao(ordemDeCompra.getValor_total_operacao());
        dto.setConta(ordemDeCompra.getConta());
        return dto;
    }

    public OrdemDeCompra toEntity(){
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra();
        ordemDeCompra.setId(id_compra);
        ordemDeCompra.setId_cliente(id_cliente);
        ordemDeCompra.setCpf_cliente(cpf_cliente);
        ordemDeCompra.setDataSolicitacao(dataSolicitacao);
        ordemDeCompra.setTipo_moeda(tipo_moeda);
        ordemDeCompra.setValor_cotacao(valor_cotacao);
        ordemDeCompra.setValor_moeda_estrangeira(valor_moeda_estrangeira);
        ordemDeCompra.setValor_total_operacao(valor_total_operacao);
        ordemDeCompra.setConta(conta);
        return ordemDeCompra;
    }

}
