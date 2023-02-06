package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordemDeCompra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService service;

    @GetMapping("{id}")
    public ResponseEntity<OrdemDeCompraDTO> getById(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um ID!");
        }

        OrdemDeCompra entity = service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada a compra com o ID informado!"));
        var tipoMoeda = entity.getTipoMoeda();
        var conta = entity.getNumeroAgencia();
        OrdemDeCompraDTO entityDTO = service.consultarCotacaoECliente(tipoMoeda, conta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada um compra com essas informações!"));
        return ResponseEntity.ok(OrdemDeCompraDTO.of(entityDTO.toEntity()));
    }
    @GetMapping("{tipoMoeda}/{conta}")
    public ResponseEntity<OrdemDeCompraDTO> getByContaETipoMoeda(@PathVariable String conta, @PathVariable String tipoMoeda) {
        if (conta == null || conta.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado a Conta!");
        }
        OrdemDeCompraDTO entity = service.consultarCotacaoECliente(tipoMoeda, conta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada um compra com essas informações!"));
        return ResponseEntity.ok(OrdemDeCompraDTO.of(entity.toEntity()));

    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody OrdemDeCompraDTO ordemDeCompra) {
        if(ordemDeCompra.getNumero_agencia_retirada() == null || ordemDeCompra.getValor_moeda_estrangeira() == null || ordemDeCompra.getCpf_cliente() == null || ordemDeCompra.getTipo_moeda() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todos os campos precisam ser preenchidos");
        }
        if(!ordemDeCompra.getTipo_moeda().toUpperCase().equals("USD") && !ordemDeCompra.getTipo_moeda().toUpperCase().equals("EUR")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda incorreta. Escolha USD ou EUR");
        }
        try {
            ordemDeCompra.setValor_total_operacao(ordemDeCompra.getValor_cotacao()*ordemDeCompra.getValor_moeda_estrangeira());
            service.add(ordemDeCompra.toEntity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/api/ordemDeCompra/" + ordemDeCompra.getId_compra())).build();
    }
}
