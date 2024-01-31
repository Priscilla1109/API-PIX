package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

//CLASSE: para construir Payloads do PIX
public class PixPayloadBuilder {
    //ATRIBUTOS: Campos da chave PIX
    private String chavePix;
    private String nome;
    private double valor;

    //MÉTODOS: ajudam a definir os valores desses campos de maneira encadeada
    public PixPayloadBuilder withChavePix(String chavePix){
        this.chavePix = chavePix;
        return this;
    }

    public PixPayloadBuilder withNome(String nome){
        this.nome = nome;
        return this;
    }

    public PixPayloadBuilder withValor(double valor){
        this.valor = valor;
        return this;
    }

    //MAP: Mapa com valores dos campos
    public Map<String, Object> build(){
        Map<String, Object> pixPayload = new HashMap<>();
        pixPayload.put("chavePix", chavePix);
        pixPayload.put("nome", nome);
        pixPayload.put("valor", valor);
        return pixPayload;
    }

    //MÉTODO: Converte o mapa para um arquivo JSON usando a biblioteca Jackson
    public String buildJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(build());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
