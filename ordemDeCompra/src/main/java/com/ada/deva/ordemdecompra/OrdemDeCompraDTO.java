package com.ada.deva.ordemdecompra;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class OrdemDeCompraDTO {
    private String id_compra;
    

    private String id_cliente;
    
    private String cpf_cliente;
    
    private String tipo_moeda;
    
    private Double valor_moeda_estrangeira;

    private BigDecimal valor_cotacao;
    private LocalDateTime dataSolicitacao;
    private String numero_agencia_retirada;


    public OrdemDeCompraDTO(String id_compra, String id_cliente, String cpf_cliente, String tipo_moeda, Double valor_moeda_estrangeira, BigDecimal valor_cotacao, LocalDateTime dataSolicitacao, String numero_agencia_retirada) {
    }

    public static OrdemDeCompraDTO of(OrdemDeCompra ordemDeCompra){
        OrdemDeCompraDTO dto = new OrdemDeCompraDTO();
        dto.setId_compra(ordemDeCompra.getId());
        dto.setId_cliente(ordemDeCompra.getCPF());
        dto.setTipo_moeda(ordemDeCompra.getTipoMoeda());
        dto.setValor_moeda_estrangeira(ordemDeCompra.getValorMoedaEstrangeira());
        dto.setNumero_agencia_retirada(ordemDeCompra.getNumeroAgencia());
        return dto;
    }

    public OrdemDeCompra toEntity(){
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra();
        ordemDeCompra.setId(id_compra);
        ordemDeCompra.setCPF(cpf_cliente);
        ordemDeCompra.setTipoMoeda(tipo_moeda);
        ordemDeCompra.setValorMoedaEstrangeira(valor_moeda_estrangeira);
        ordemDeCompra.setNumeroAgencia(numero_agencia_retirada);
        return ordemDeCompra;
    }

}
