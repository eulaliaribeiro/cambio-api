package com.ada.deva.ordemdecompra;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemDeCompraService {
    private final OrdemDeCompraRepository ordemDeCompraRepository;
    private final CotacaoClient cotacaoClient;
    private final ClienteClient clienteClient;
    OrdemDeCompra ordemDeCompraDTO = new OrdemDeCompra();

    public Optional<OrdemDeCompra> getById(Long id) {
        var ordemDeCompra = ordemDeCompraRepository.findById(id);
        return ordemDeCompra;
    }


    public void adicionar(OrdemDeCompra ordemDeCompra){
        ordemDeCompraRepository.save(ordemDeCompra);
    }

    public OrdemDeCompra salvarEntity(OrdemDeCompraDTO ordemDeCompra){
        ClienteDTO cliente = clienteClient.getCadastro(ordemDeCompra.getConta());
        CotacaoDTO cotacao = cotacaoClient.getCotacao(ordemDeCompra.getTipo_moeda());
        Double valorCotacao = cotacao.getValor_cotacao();
        ordemDeCompraDTO.setId(ordemDeCompra.getId_compra());
        ordemDeCompraDTO.setId_cliente(cliente.getId_cliente());
        ordemDeCompraDTO.setCpf_cliente(cliente.getCpf_cliente());
        ordemDeCompraDTO.setDataSolicitacao(LocalDateTime.now());
        ordemDeCompraDTO.setTipo_moeda(ordemDeCompra.getTipo_moeda());
        ordemDeCompraDTO.setValor_moeda_estrangeira(ordemDeCompra.getValor_moeda_estrangeira());
        ordemDeCompraDTO.setConta(ordemDeCompra.getConta());
        ordemDeCompraDTO.setValor_cotacao(valorCotacao);
        if(ordemDeCompra.getTipo_moeda().equalsIgnoreCase("USD") || ordemDeCompra.getTipo_moeda().equalsIgnoreCase("EUR")){
            ordemDeCompraDTO.setValor_total_operacao(valorCotacao * ordemDeCompra.getValor_moeda_estrangeira());
        }
        adicionar(ordemDeCompraDTO);
        return ordemDeCompraDTO;
    }
}
