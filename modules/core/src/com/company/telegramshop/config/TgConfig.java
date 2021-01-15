package com.company.telegramshop.config;

import com.company.telegramshop.config.utills.*;
import com.company.telegramshop.entity.SendFoto;
import com.company.telegramshop.service.FoodService;
import com.company.telegramshop.service.UserService;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;
import java.util.List;

@Component
public class TgConfig extends TelegramLongPollingBot {
    @Inject private CommandUtils utils;
    @Inject private ButtonUtils buttonUtils;
    @Inject private Keybord keybord;
    @Inject private FoodService foodService;
    @Inject private UserService userService;
    @Inject private CommandText commandText;
    @Inject private MediaUtils mediaUtils;
    @Inject Authentication authentication;
    @Inject
    private FileLoader fileLoader;

    @Override
    public String getBotUsername() {
        return "lolMessagBot";
    }

    @Override
    public String getBotToken() {
        return "1487031714:AAEz7teOXNw1CmUG9BCUxp225NcWYVZ8p5w";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            if (update.getMessage().getText().equals("/start")) {
                sendMsg(commandText.start(update));
            }
        }else if (update.hasCallbackQuery()){
            String data = update.getCallbackQuery().getData();
            if (data.equals("menuCalRus")){
                editMsg(commandText.lang(update));
            }else if (data.equals("food")){
                sendMedia(mediaUtils.photo(update));



            }else if (data.startsWith("Image#")){
                editMedia(mediaUtils.edit(update));

//
            }
        }
    }






    public void sendMsg(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void editMsg(EditMessageText editMessageText){
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendPhoto(SendPhoto sendPhoto){
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void sendMedia(SendMediaGroup sendMediaGroup){
        try {
            execute(sendMediaGroup);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void editMedia(EditMessageMedia editMessageMedia){
        try {
            execute(editMessageMedia);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
