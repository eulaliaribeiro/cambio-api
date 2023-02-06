package com.ada.deva.cotacao;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

public class CotacaoClient {

    WebClient webClient = WebClient.create();
    public CotacaoDTO getCotacao(String code){

        Flux<CotacaoDTO> cotacaoFlux =
                webClient.get().uri("https://economia.awesomeapi.com.br/{code}", code).retrieve().bodyToFlux(CotacaoDTO.class);

        return  cotacaoFlux
                .collect(Collectors.toList())
                .share().block().iterator().next();
    }
}