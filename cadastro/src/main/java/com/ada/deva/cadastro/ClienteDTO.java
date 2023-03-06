package com.ada.deva.cadastro;

import lombok.Data;

@Data
public class ClienteDTO {

    private final String id_cliente;
    private final String cpf_cliente;
    private final String nome;
    private String dataNascimento;
    private String estadoCivil;
    private String sexo;
    private String conta;

    public static ClienteDTO of(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO(cliente.getId(), cliente.getCpf(), cliente.getNome());
        dto.dataNascimento = cliente.getDataNascimento();
        dto.estadoCivil = cliente.getEstadoCivil();
        dto.sexo = cliente.getSexo();
        dto.conta = cliente.getConta();
        return dto;
    }

    public Cliente toEntity() {
        Cliente entity = new Cliente();
        entity.setId(id_cliente);
        entity.setCpf(cpf_cliente);
        entity.setNome(nome);
        entity.setDataNascimento(dataNascimento);
        entity.setEstadoCivil(estadoCivil);
        entity.setSexo(sexo);
        entity.setConta(conta);
        return entity;
    }
}