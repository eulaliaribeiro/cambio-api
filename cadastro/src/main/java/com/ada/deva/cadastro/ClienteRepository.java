package com.ada.deva.cadastro;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
    Cliente findByConta(String conta);
}
