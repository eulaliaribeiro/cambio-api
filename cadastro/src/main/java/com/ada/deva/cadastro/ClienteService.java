package com.ada.deva.cadastro;

import com.ada.deva.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Component
public class ClienteService {
    private final ClienteRepository repository;

    public Optional<Cliente> getById(String id) {
        return repository.findById(id);
    }
    public Optional<Cliente> getByConta(String conta) {
        return Optional.ofNullable(repository.findByConta(conta));
    }

    public void adicionar(Cliente entity) throws EntidadeDuplicadaException {
        entity.setId(String.valueOf(new Random().nextLong()));

        if (repository.existsById(entity.getId())) {
            throw new EntidadeDuplicadaException();
        }
        repository.save(entity);
    }
}