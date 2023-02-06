package com.ada.deva.ordemdecompra;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class ClienteDTO {
    private String cpf;
    private String nome;
    private String dataNascimento;
    private String estadoCivil;
    private String sexo;

    private String conta;



//    public ClienteDTO(String cpf, String nome) {
//
//    }
//
//    public static ClienteDTO of(Cliente cliente) {
//        ClienteDTO dto = new ClienteDTO(cliente.getCpf(), cliente.getNome());
//        dto.dataNascimento = cliente.getDataNascimento();
//        dto.estadoCivil = cliente.getEstadoCivil();
//        dto.sexo = cliente.getSexo();
//        dto.conta = cliente.getConta();
//        return dto;
//    }
//
//    public Cliente toEntity() {
//        Cliente entity = new Cliente();
//        entity.setCpf(cpf);
//        entity.setNome(nome);
//        entity.setDataNascimento(String.valueOf(dataNascimento));
//        entity.setEstadoCivil(estadoCivil);
//        entity.setSexo(sexo);
//        entity.setConta(conta);
//        return entity;
//    }
}