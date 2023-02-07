package com.ada.deva.ordemdecompra;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class OrdemDeCompra {
    @Id
    private Long id_compra;


    private String id_cliente;

    private String cpf_cliente;

    private String tipo_moeda;

    private Double valor_moeda_estrangeira;

    private Double valor_cotacao;
    private Double valor_total_operacao;
    private LocalDateTime dataSolicitacao;
    private String conta;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getCPF() {
//        return CPF;
//    }
//
//    public void setCPF(String CPF) {
//        this.CPF = CPF;
//    }
//
//
//    public String getTipoMoeda() {
//        return tipoMoeda;
//    }
//
//    public void setTipoMoeda(String tipoMoeda) {
//        this.tipoMoeda = tipoMoeda;
//    }
//
//    public double getValorMoedaEstrangeira() {
//        return valorMoedaEstrangeira;
//    }
//
//    public void setValorMoedaEstrangeira(double valorMoedaEstrangeira) {
//        this.valorMoedaEstrangeira = valorMoedaEstrangeira;
//    }
//
//    public String getNumeroAgencia() {
//        return numeroAgencia;
//    }
//
//    public void setNumeroAgencia(String numeroAgencia) {
//        this.numeroAgencia = numeroAgencia;
//    }
//

}
