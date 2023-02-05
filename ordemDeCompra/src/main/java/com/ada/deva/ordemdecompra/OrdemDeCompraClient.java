package com.ada.deva.ordemdecompra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class OrdemDeCompraClient{
    WebClient webClient = WebClient.create();
    public OrdemDeCompraDTO getCotacao(String tipoMoeda){
        return webClient.get().uri("http://localhost:8080/cotacao/{tipoMoeda}", tipoMoeda).retrieve().bodyToMono(OrdemDeCompraDTO.class).block();
    }

    public OrdemDeCompraDTO getCadastro(String conta){
        return webClient.get().uri("http://localhost:8080/api/cliente/{conta}", conta).retrieve().bodyToMono(OrdemDeCompraDTO.class).block();
    }
}
