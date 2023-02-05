package com.ada.deva.ordemdecompra;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class OrdemDeCompra {
    @Id
    private String id;
    private String CPF;
    private String tipoMoeda;
    private double valorMoedaEstrangeira;
    private String numeroAgencia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }


    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public double getValorMoedaEstrangeira() {
        return valorMoedaEstrangeira;
    }

    public void setValorMoedaEstrangeira(double valorMoedaEstrangeira) {
        this.valorMoedaEstrangeira = valorMoedaEstrangeira;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }


}
