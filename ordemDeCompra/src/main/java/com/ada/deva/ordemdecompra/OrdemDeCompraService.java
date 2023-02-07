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
    OrdemDeCompra ordemDeCompra = new OrdemDeCompra();

    public Optional<OrdemDeCompra> getById(Long id) {
        var ordemDeCompra = ordemDeCompraRepository.findById(id);
        return ordemDeCompra;
    }

    public void adicionar(OrdemDeCompra ordemDeCompra){
        ordemDeCompraRepository.save(ordemDeCompra);
    }

    public OrdemDeCompra salvarEntity(OrdemDeCompraDTO ordemDeCompraDTO){
        ClienteDTO cliente = clienteClient.getCadastro(ordemDeCompraDTO.getConta());
        CotacaoDTO cotacao = cotacaoClient.getCotacao(ordemDeCompraDTO.getTipo_moeda());
        Double valorCotacao = cotacao.getValor_cotacao();
        this.ordemDeCompra.setId(ordemDeCompraDTO.getId_compra());
        this.ordemDeCompra.setId_cliente(cliente.getId_cliente());
        this.ordemDeCompra.setCpf_cliente(cliente.getCpf_cliente());
        this.ordemDeCompra.setDataSolicitacao(LocalDateTime.now());
        this.ordemDeCompra.setTipo_moeda(ordemDeCompraDTO.getTipo_moeda());
        this.ordemDeCompra.setValor_moeda_estrangeira(ordemDeCompraDTO.getValor_moeda_estrangeira());
        this.ordemDeCompra.setConta(ordemDeCompraDTO.getConta());
        this.ordemDeCompra.setValor_cotacao(valorCotacao);
        if(ordemDeCompraDTO.getTipo_moeda().equalsIgnoreCase("USD") || ordemDeCompraDTO.getTipo_moeda().equalsIgnoreCase("EUR")){
            this.ordemDeCompra.setValor_total_operacao(valorCotacao * ordemDeCompraDTO.getValor_moeda_estrangeira());
        }
        adicionar(this.ordemDeCompra);
        return this.ordemDeCompra;
    }
}
