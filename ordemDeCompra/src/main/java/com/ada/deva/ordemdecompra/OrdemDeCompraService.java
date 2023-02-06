package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemDeCompraService {
    private final OrdemDeCompraRepository repository;

    public Optional<OrdemDeCompra> getById(String id){
        return repository.findById(id);
    }

    public void add(OrdemDeCompra entity){
        repository.save(entity);
    }

    public Optional<OrdemDeCompraDTO> consultarCotacaoECliente(String tipoMoeda, String conta) {
        OrdemDeCompraClient ordemDeCompraClient = new OrdemDeCompraClient();
        OrdemDeCompraDTO ordemDeCompra = ordemDeCompraClient.getCadastro(conta);
        OrdemDeCompraDTO ordemDeCompra1 = ordemDeCompraClient.getCotacao(tipoMoeda);

        OrdemDeCompraDTO ordemDeCompraDTO = new OrdemDeCompraDTO(
                ordemDeCompra.getId_compra(),
                ordemDeCompra.getId_cliente(),
                ordemDeCompra.getCpf_cliente(),
                ordemDeCompra1.getTipo_moeda(),
                ordemDeCompra.getValor_moeda_estrangeira(),
                ordemDeCompra1.getValor_cotacao(),
                ordemDeCompra1.getDataSolicitacao(),
                ordemDeCompra.getNumero_agencia_retirada());

        return Optional.of(ordemDeCompraDTO);

    }
}
