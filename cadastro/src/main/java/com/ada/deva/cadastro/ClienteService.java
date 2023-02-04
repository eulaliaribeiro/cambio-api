package com.ada.deva.cadastro;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final CrudRepository<Cliente, String> repository;

    public Optional<Cliente> getById(String id) {
        return repository.findById(id);
    }

    public void adicionar(Cliente entity) throws EntidadeDuplicadaException {
        if (repository.existsById(entity.getCpf())) {
            throw new EntidadeDuplicadaException();
        }
        repository.save(entity);
    }
}