package com.ada.deva.ordemdecompra;


import com.ada.deva.cadastro.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class OrdemDeCompraService {
    private final OrdemDeCompraRepository repository;
    private final CotacaoClient cotacaoClient;
    private final ClienteClient clienteClient;
    OrdemDeCompraDTO ordemDeCompraDTO = new OrdemDeCompraDTO();

    public Optional<OrdemDeCompra> getById(String id) {
        return repository.findById(id);
    }

//    public Optional<OrdemDeCompraDTO> consultarCotacaoECliente(String tipoMoeda, String conta) {
//        OrdemDeCompraClient ordemDeCompraClient = new OrdemDeCompraClient();
//        OrdemDeCompraDTO ordemDeCompra = ordemDeCompraClient.getCadastro(conta);
//        OrdemDeCompraDTO ordemDeCompra1 = ordemDeCompraClient.getCotacao(tipoMoeda);
//
//        OrdemDeCompraDTO ordemDeCompraDTO = new OrdemDeCompraDTO(
//                ordemDeCompra.getId_compra(),
//                ordemDeCompra.getId_cliente(),
//                ordemDeCompra.getCpf_cliente(),
//                ordemDeCompra1.getTipo_moeda(),
//                ordemDeCompra.getValor_moeda_estrangeira(),
//                ordemDeCompra1.getValor_cotacao(),
//                ordemDeCompra1.getDataSolicitacao(),
//                ordemDeCompra.getNumero_agencia_retirada());
//
//        return Optional.of(ordemDeCompraDTO);
//
//    }

    public OrdemDeCompraDTO salvarEmDTO(OrdemDeCompra ordemDeCompra){
        ClienteDTO cliente = clienteClient.getCadastro(ordemDeCompra.getConta());
        CotacaoDTO cotacao = cotacaoClient.getCotacao(ordemDeCompra.getTipo_moeda());
        Double valorCotacao = cotacao.getValor_cotacao();
        ordemDeCompraDTO.setId_compra(String.valueOf(new Random().nextLong()));
        ordemDeCompraDTO.setId_cliente(cliente.getId_cliente());
        ordemDeCompraDTO.setCpf_cliente(cliente.getCpf_cliente());
        ordemDeCompraDTO.setDataSolicitacao(LocalDateTime.now());
        ordemDeCompraDTO.setTipo_moeda(ordemDeCompra.getTipo_moeda());
        ordemDeCompraDTO.setValor_moeda_estrangeira(ordemDeCompra.getValorMoedaEstrangeira());
        ordemDeCompraDTO.setNumero_agencia_retirada(ordemDeCompra.getConta());
        ordemDeCompraDTO.setValor_cotacao(valorCotacao);
        if(ordemDeCompra.getTipo_moeda().equalsIgnoreCase("USD") || ordemDeCompra.getTipo_moeda().equalsIgnoreCase("EUR")){
            ordemDeCompraDTO.setValor_total_operacao(valorCotacao * ordemDeCompra.getValorMoedaEstrangeira());
        }
        return ordemDeCompraDTO;
    }
}
