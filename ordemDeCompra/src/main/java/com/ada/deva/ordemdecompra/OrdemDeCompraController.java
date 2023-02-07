package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada uma reserva com o ID informado!"));
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
    public ResponseEntity<Object> criarOrdemDeCompra(@RequestBody OrdemDeCompraDTO ordemDeCompra) {
//            if(ordemDeCompra.getId_compra() == null){
//                ordemDeCompra.setId_compra(new Random().nextLong());
//            }
        OrdemDeCompra ordemDeCompra1 = ordemDeCompraService.salvarEntity(ordemDeCompra);
        log.info("Info {}", ordemDeCompra);
        System.out.println(ordemDeCompra1);
        System.out.println(ordemDeCompra);
        return ResponseEntity.created(URI.create("api/ordemDeCompra/" + ordemDeCompra1.getId())).build();
    }
}

