package com.ada.deva.ordemdecompra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Component
public class CotacaoClient {
    public OrdemDeCompraDTO getCotacao(String tipoMoeda){
        WebClient webClient = WebClient.create();
        return webClient.get().uri("http://localhost:8082/cotacao/{{tipoMoeda}}", tipoMoeda).retrieve().bodyToMono(OrdemDeCompraDTO.class).block();
    }
}
