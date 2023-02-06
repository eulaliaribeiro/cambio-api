package com.ada.deva.ordemdecompra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Component
public class CotacaoClient {
    WebClient webClient = WebClient.create();
    private String URI = "http://localhost:8082/cotacao/{{tipoMoeda}}";
    public CotacaoDTO getCotacao(String tipoMoeda){
        return webClient.get().uri(URI, tipoMoeda).retrieve().bodyToMono(CotacaoDTO.class).block();
    }
}
