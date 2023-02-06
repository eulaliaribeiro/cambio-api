package com.ada.deva.ordemdecompra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component
@Slf4j
public class ClienteClient {

    public OrdemDeCompraDTO getCadastro(String conta){
        WebClient webClient = WebClient.create();
        return webClient.get().uri("http://localhost:8083/api/cliente/conta/{{conta}}", conta).retrieve().bodyToMono(OrdemDeCompraDTO.class).block();
    }
}
