package com.ada.deva.cotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cotacao")
public class CotacaoController {
    private final CotacaoService service;
    @GetMapping("/{tipo_moeda}")
    public ResponseEntity<Cotacao> consultarCotacao(@PathVariable String tipo_moeda) {

        if (!(tipo_moeda.equals("EUR") || tipo_moeda.equals("USD"))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Código da moeda inválido!");
        }

        Optional<Cotacao> cotacao = service.consultarCotacao(tipo_moeda);
        cotacao.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cotação não encontrada!"));

        Cotacao response = cotacao.get();

        return ResponseEntity.ok(response);
    }

}
