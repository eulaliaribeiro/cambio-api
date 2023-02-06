package com.ada.deva.cotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ada.deva.cotacao.DataFormatter.dataFormatter;

@Service
@RequiredArgsConstructor
@Component
public class CotacaoService {
    CotacaoClient cotacaoClient = new CotacaoClient();
    public Optional<Cotacao> consultarCotacao(String tipo_moeda) {
        CotacaoDTO cotacaoDto = cotacaoClient.getCotacao(tipo_moeda);

        Cotacao cotacao = new Cotacao(
                cotacaoDto.getCode(),
                cotacaoDto.getBid(),
                dataFormatter(cotacaoDto.getCreate_date()));

        return Optional.of(cotacao);

    }

    public Double valorCotacao(String tipo_moeda){
        CotacaoDTO cotacaoDto = cotacaoClient.getCotacao(tipo_moeda);
        return cotacaoDto.getLow();
    }



}