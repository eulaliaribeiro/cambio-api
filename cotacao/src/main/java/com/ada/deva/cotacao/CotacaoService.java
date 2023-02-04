package com.ada.deva.cotacao;

import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ada.deva.cotacao.DataFormatter.dataFormatter;

@Service
public class CotacaoService {
    public Optional<Cotacao> consultarCotacao(String tipo_moeda) {
        CotacaoClient cotacaoClient = new CotacaoClient();
        CotacaoDTO cotacaoDto = cotacaoClient.getCotacao(tipo_moeda);


        Cotacao cotacao = new Cotacao(
                cotacaoDto.getCode(),
                cotacaoDto.getBid(),
                dataFormatter(cotacaoDto.getCreate_date()));

        return Optional.of(cotacao);

    }



}