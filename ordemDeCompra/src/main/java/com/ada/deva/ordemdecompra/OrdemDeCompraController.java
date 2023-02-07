package com.ada.deva.ordemdecompra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/ordemDeCompra")
@Slf4j
public class OrdemDeCompraController {
    private final OrdemDeCompraService service;

    @GetMapping("{id}")
    public OrdemDeCompraDTO getById(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um ID!");
        }
        OrdemDeCompra entity = service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada a compra com o ID informado!"));
        return ResponseEntity.ok(OrdemDeCompraDTO.of(entity)).getBody();
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
        if(ordemDeCompra.getId_compra().isBlank() || ordemDeCompra.getTipo_moeda().isBlank() || ordemDeCompra.getValorMoedaEstrangeira() == 0 || ordemDeCompra.getConta().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todos os campos precism estar preenchidos");
        }
        try{
            OrdemDeCompraDTO teste = service.salvarEmDTO(ordemDeCompra);
            log.info("Info {}", ordemDeCompra);
            return teste;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }

    }
}

