package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PixHttpClient {
    private static final String API_URL = "https://api.com/api/pix"; //Represnta um ENDPOINT que vai receber a requisição
    private static final String CHAVE_API = "chaveApi"; //Chave de autenticação da API

    public static void main(String[] args) {
        String jsonPayload = new PixPayloadBuilder() //Instancia para construir o objeto payload do PIX
                .withChavePix("Chave Pix")
                .withNome("Nome")
                .withValor(225.00)
                .buildJson(); //converte para uma String JSON

        try {
            sendPixRequest(API_URL, CHAVE_API, jsonPayload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //MÉTODO: Envia a requisição HTTP para a API PIX
    private static void sendPixRequest(String apiUrl, String chaveApi, String jsonPayload) throws Exception{
        HttpClient httpClient = HttpClient.newHttpClient(); //cria uma requisição

        HttpRequest httpRequest = HttpRequest.newBuilder() //configura os detelhes da requisição
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Chave-Api", chaveApi)
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))//solicitar que o servidor web aceite os dados anexados no corpo da mensagem de requisição para armazenamento
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()); //requisição é enviada para a API

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response: " + response.body());
    }
}
