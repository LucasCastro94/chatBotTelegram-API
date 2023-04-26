package com.github.lucascastro94.botTelegramAPI.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lucascastro94.botTelegramAPI.dto.MessageSend;
import com.github.lucascastro94.botTelegramAPI.dto.ResultBotTelegramList;
import com.github.lucascastro94.botTelegramAPI.service.Telegram;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/telegram")
public class TelegramController {

    private Telegram telegram;
    private ObjectMapper objectMapper;

    public TelegramController(Telegram telegram, ObjectMapper objectMapper) {
        this.telegram = telegram;
        this.objectMapper = objectMapper;
    }


    @PostMapping
    public ResponseEntity enviarMsg(@RequestBody MessageSend messageRequest) {
        telegram.enviarMensagem(messageRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<ResultBotTelegramList> buscarAtualizações() {
        ResultBotTelegramList getUpdatesResultBotTelegram = telegram.buscarAtualizacao();
        return ResponseEntity.ok(getUpdatesResultBotTelegram);
    }
}
