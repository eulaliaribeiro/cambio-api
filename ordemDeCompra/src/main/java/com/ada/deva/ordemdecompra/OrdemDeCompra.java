package com.ada.deva.ordemdecompra;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class OrdemDeCompra {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id_compra;
    private String cpf_cliente;
    private LocalDate dataSolicitacao;
    private String tipo_moeda;
    private double valorMoedaEstrangeira;
    private Double valorCotacao;
    private Double valorTotalOperacao;
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
