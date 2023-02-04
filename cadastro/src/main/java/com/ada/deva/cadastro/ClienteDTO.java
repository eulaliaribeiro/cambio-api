package com.ada.deva.cadastro;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDTO {
    private final String cpf;
    private final String nome;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

    public static ClienteDTO of(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO(cliente.getCpf(), cliente.getNome());
        dto.dataNascimento = cliente.getDataNascimento();
        dto.estadoCivil = cliente.getEstadoCivil();
        dto.sexo = cliente.getSexo();
        return dto;
    }

    public Cliente toEntity() {
        Cliente entity = new Cliente();
        entity.setCpf(cpf);
        entity.setNome(nome);
        entity.setDataNascimento(dataNascimento);
        entity.setEstadoCivil(estadoCivil);
        entity.setSexo(sexo);
        return entity;
    }
}