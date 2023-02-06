package com.ada.deva.ordemdecompra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component
@Slf4j
public class ClienteClient {
    WebClient webClient = WebClient.create();
    private String URI = "http://localhost:8083/api/cliente/conta/";

    public ClienteDTO getCadastro(String conta){
        return webClient.get().uri(URI + conta).retrieve().bodyToMono(ClienteDTO.class).block();
    }
}
