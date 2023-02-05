package com.ada.deva.ordemdecompra;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class OrdemDeCompraDTO {
    private String idCompra;

    private String idCliente;
    private String cpf;
    private String tipoMoeda;
    private Double valorMoedaEstrangeira;

    private BigDecimal valorCotacao;
    private LocalDateTime dataSolicitacao;
    private String numeroAgencia;


    public OrdemDeCompraDTO(String id, String cpf, String tipoMoeda, Double valorMoedaEstrangeira, BigDecimal valorCotacao, LocalDateTime dataSolicitacao, String numeroAgencia) {
    }

    public static OrdemDeCompraDTO of(OrdemDeCompra ordemDeCompra){
        OrdemDeCompraDTO dto = new OrdemDeCompraDTO();
        dto.setIdCompra(ordemDeCompra.getId());
        dto.setCpf(ordemDeCompra.getCPF());
        dto.setTipoMoeda(ordemDeCompra.getTipoMoeda());
        dto.setValorMoedaEstrangeira(ordemDeCompra.getValorMoedaEstrangeira());
        dto.setNumeroAgencia(ordemDeCompra.getNumeroAgencia());
        return dto;
    }

    public OrdemDeCompra toEntity(){
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra();
        ordemDeCompra.setId(idCompra);
        ordemDeCompra.setCPF(cpf);
        ordemDeCompra.setTipoMoeda(tipoMoeda);
        ordemDeCompra.setValorMoedaEstrangeira(valorMoedaEstrangeira);
        ordemDeCompra.setNumeroAgencia(numeroAgencia);
        return ordemDeCompra;
    }

}
