package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemDeCompraService {
    private final CrudRepository<OrdemDeCompra, String> repository;

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
                ordemDeCompra.getIdCompra(),
                ordemDeCompra.getCpf(),
                ordemDeCompra1.getTipoMoeda(),
                ordemDeCompra.getValorMoedaEstrangeira(),
                ordemDeCompra1.getValorCotacao(),
                ordemDeCompra1.getDataSolicitacao(),
                ordemDeCompra.getNumeroAgencia());

        return Optional.of(ordemDeCompraDTO);

    }
}
