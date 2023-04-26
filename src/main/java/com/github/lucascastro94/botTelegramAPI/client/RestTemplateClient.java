package com.github.lucascastro94.botTelegramAPI.client;


import com.github.lucascastro94.botTelegramAPI.dto.MessageSend;
import com.github.lucascastro94.botTelegramAPI.dto.ResultBotTelegram;
import com.github.lucascastro94.botTelegramAPI.dto.ResultBotTelegramList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestTemplateClient {
    @Value("${telegram.api}")
    private String BASE_PATH;
    @Value("${telegram.token}")
    private String TOKEN;


    private RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void enviarMensagem(MessageSend msg) {

        ResultBotTelegram retorno = restTemplate.postForObject(BASE_PATH + TOKEN + "/sendMessage",
                msg, ResultBotTelegram.class);

    }

    public ResultBotTelegramList buscarAtualizacao() {
        ResultBotTelegramList forObject = restTemplate.getForObject(BASE_PATH + TOKEN + "/getUpdates", ResultBotTelegramList.class);
        return forObject;
    }


}



