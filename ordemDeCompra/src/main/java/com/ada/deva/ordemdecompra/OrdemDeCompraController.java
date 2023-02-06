package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.net.URI;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/ordemDeCompra")
@Slf4j
public class OrdemDeCompraController {
    private final OrdemDeCompraService service;

//    @GetMapping("{id}")
//    public OrdemDeCompraDTO getById(@PathVariable String id) {
//        if (id == null || id.isBlank()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um ID!");
//        }
//        OrdemDeCompra entity = service.getById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada a compra com o ID informado!"));
//        var tipoMoeda = entity.getTipoMoeda();
//        var conta = entity.getNumeroAgencia();
//        OrdemDeCompraDTO entityDTO = service.consultarCotacaoECliente(tipoMoeda, conta)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada um compra com essas informações!"));
//        return entityDTO;
//    }
//    @GetMapping("{tipoMoeda}/{conta}")
//    public ResponseEntity<OrdemDeCompraDTO> getByContaETipoMoeda(@PathVariable String conta, @PathVariable String tipoMoeda) {
//        if (conta == null || conta.isBlank()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado a Conta!");
//        }
//        OrdemDeCompraDTO entity = service.consultarCotacaoECliente(tipoMoeda, conta)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada um compra com essas informações!"));
//        return ResponseEntity.ok(OrdemDeCompraDTO.of(entity.toEntity()));

//    }

    @PostMapping(path = "", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemDeCompraDTO criarOrdemDeCompra(@RequestBody OrdemDeCompra ordemDeCompra) {
            OrdemDeCompraDTO teste = service.salvarEmDTO(ordemDeCompra);
            log.info("Info {}", ordemDeCompra);
            return teste;
    }
}
