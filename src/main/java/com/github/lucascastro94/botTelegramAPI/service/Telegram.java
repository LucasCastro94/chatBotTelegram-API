package com.github.lucascastro94.botTelegramAPI.service;


import com.github.lucascastro94.botTelegramAPI.client.RestTemplateClient;
import com.github.lucascastro94.botTelegramAPI.dto.MessageSend;
import com.github.lucascastro94.botTelegramAPI.dto.ResultBotTelegramList;
import org.springframework.stereotype.Service;

@Service
public class Telegram{


    private RestTemplateClient restTemplateClient;

    public Telegram(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    public void enviarMensagem(MessageSend mensagem) {
      restTemplateClient.enviarMensagem(mensagem);
    }


    public ResultBotTelegramList buscarAtualizacao() {
        ResultBotTelegramList resultBotTelegramList = restTemplateClient.buscarAtualizacao();
        return resultBotTelegramList;
    }
}
