package com.company.telegramshop.config.utills;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


@Component
public class CommandUtils {

    public SendMessage message(String text, String id){
        if (text.equals("/start")){
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("sasd");
            sendMessage.setChatId(id);
            return sendMessage;
        }
        return null;
    }



}
