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
    private String id_cliente;
    private String cpf_cliente;
    private String nome;
    private String dataNascimento;
    private String estadoCivil;
    private String sexo;

    private String conta;
}