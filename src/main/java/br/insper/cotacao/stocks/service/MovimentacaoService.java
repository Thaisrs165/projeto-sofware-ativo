package br.insper.cotacao.stocks.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class MovimentacaoService {


    @Value("${movimentacao.url}")
    private String movimentacaoUrl;

    public List<Movimentacao> getMovimetacoes() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Movimentacao>> response =
                restTemplate.exchange(
                        movimentacaoUrl + "/movimentacoes",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        return response.getBody();
    }
}
