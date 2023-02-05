package com.ada.deva.cadastro;

import com.ada.deva.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository repository;

    public Optional<Cliente> getById(String id) {
        return repository.findById(id);
    }
    public Optional<Cliente> getByConta(String conta) {
        return Optional.ofNullable(repository.findByConta(conta));
    }

    public void adicionar(Cliente entity) throws EntidadeDuplicadaException {
        if (repository.existsById(entity.getCpf())) {
            throw new EntidadeDuplicadaException();
        }
        repository.save(entity);
    }
}