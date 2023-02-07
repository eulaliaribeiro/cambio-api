package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Random;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/ordemDeCompra")
@Slf4j
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;

    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeCompraDTO> findById(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não informado!");
        }
        OrdemDeCompra entity = ordemDeCompraService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontramos ordem de compra com ID informado."));
        return ResponseEntity.ok(OrdemDeCompraDTO.of(entity));
    }
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
            OrdemDeCompraDTO teste = ordemDeCompraService.salvarEmDTO(ordemDeCompra);
            log.info("Info {}", ordemDeCompra);
            return teste;

    }
}

