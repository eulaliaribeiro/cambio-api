package com.ada.deva.cadastro;

import com.ada.deva.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService service;
    @GetMapping("{cpf}")
    public ResponseEntity<ClienteDTO> getByCpf(@PathVariable String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Atenção: O CPF não foi informado!");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        Optional<Cliente> encontrado = service.getById(cpf);
        Cliente entity = encontrado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um cliente com o CPF informado!"));
        return ResponseEntity.ok(ClienteDTO.of(entity));
    }@GetMapping("{conta}")
    public ResponseEntity<ClienteDTO> getByConta(@PathVariable String conta) {
        if (conta == null || conta.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Atenção: A conta não foi informada!");
        }
        Optional<Cliente> encontrado = service.getByConta(conta);
        Cliente entity = encontrado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um cliente com a Conta informada!"));
        return ResponseEntity.ok(ClienteDTO.of(entity));
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ClienteDTO cliente) {
        if (cliente == null || cliente.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O cliente informado é inválido.");
        }
        String clearCpf = cliente.getCpf().replaceAll("[\\.-]", "");
        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cliente com CPF válido.");
        }
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cliente com Nome válido.");
        }
        try {
            service.adicionar(cliente.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma pessoa com o CPF informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/api/cliente/" + clearCpf)).build();
    }
}