package com.ada.deva.ordemdecompra;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Optional<OrdemDeCompra> getById(String id){
        return repository.findById(id);
    }

//    public OrdemDeCompraDTO add(OrdemDeCompraDTO entity){
//        return repository.save(entity);
//    }

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
        repository.save(ordemDeCompra);
        String tipoMoeda = clienteClient.getCadastro(ordemDeCompra.getNumeroAgencia()).getTipo_moeda();
        Double valorCotacao = cotacaoClient.getCotacao(ordemDeCompra.getTipoMoeda()).getValor_cotacao();
        ordemDeCompraDTO.setId_compra(String.valueOf(new Random().nextLong()));
        ordemDeCompraDTO.setId_cliente(String.valueOf(clienteClient.getCadastro(ordemDeCompra.getNumeroAgencia()).getId_cliente()));
        ordemDeCompraDTO.setCpf_cliente(ordemDeCompra.getCPF());
        ordemDeCompraDTO.setDataSolicitacao(LocalDateTime.from(Instant.now()));
        ordemDeCompraDTO.setTipo_moeda(tipoMoeda);
        ordemDeCompraDTO.setValor_moeda_estrangeira(ordemDeCompra.getValorMoedaEstrangeira());
        ordemDeCompraDTO.setNumero_agencia_retirada(ordemDeCompra.getNumeroAgencia());
        ordemDeCompraDTO.setValor_cotacao(valorCotacao);
        if(ordemDeCompra.getTipoMoeda().equalsIgnoreCase("USD") || ordemDeCompra.getTipoMoeda().equalsIgnoreCase("EUR")){
            ordemDeCompraDTO.setValor_total_operacao(valorCotacao*(ordemDeCompra.getValorMoedaEstrangeira()));
        }
        return ordemDeCompraDTO;
    }
}
