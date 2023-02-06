package com.ada.deva.ordemdecompra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
public class OrdemDeCompraClient{
    WebClient webClient = WebClient.create();
    public OrdemDeCompraDTO getCotacao(String tipoMoeda){
        return webClient.get().uri("http://localhost:8082/cotacao/{tipoMoeda}", tipoMoeda).retrieve().bodyToMono(OrdemDeCompraDTO.class).block();
    }

    public OrdemDeCompraDTO getCadastro(String conta){
        return webClient.get().uri("http://localhost:8083/api/cliente/conta/{conta}", conta).retrieve().bodyToMono(OrdemDeCompraDTO.class).block();
    }
}
