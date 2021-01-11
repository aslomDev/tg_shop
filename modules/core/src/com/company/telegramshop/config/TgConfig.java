package com.company.telegramshop.config;

import com.company.telegramshop.config.utills.ButtonUtils;
import com.company.telegramshop.config.utills.CommandUtils;
import com.company.telegramshop.config.utills.Keybord;
import com.company.telegramshop.entity.Foods;
import com.company.telegramshop.service.FoodService;
import com.company.telegramshop.service.UserService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class TgConfig extends TelegramLongPollingBot {
    @Inject private CommandUtils utils;
    @Inject private ButtonUtils buttonUtils;
    @Inject private Keybord keybord;
    @Inject private FoodService foodService;
    @Inject private UserService userService;
    @Inject Authentication authentication;

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
        SendMessage sendMessage =new SendMessage();
        EditMessageText editMessageText = new EditMessageText();
        if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            Message message = callbackQuery.getMessage();
            if (data.equals("menuCalRus")){
                editMessageText.setText("salom menu");
                editMessageText.setChatId(String.valueOf(message.getChatId()));
                editMessageText.setMessageId(message.getMessageId());
                editMessageText.setReplyMarkup(buttonUtils.oziqMarkup());
                editMsg(editMessageText);
            }else if (data.equals("food")){
                sendMessage.setText("oziq ovqatlar");
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMsg(sendMessage);
            }
// else
//                if (data.equals("food")){
//                sendMessage.setReplyMarkup(buttonUtils.oziqMarkup());
//                sendMessage.setChatId(String.valueOf(message.getChatId()));
//                sendMsg(sendMessage);
//            }else if (data.equals("noFood")){
//                sendMessage.setReplyMarkup(buttonUtils.oziqMarkup());
//                sendMessage.setChatId(String.valueOf(message.getChatId()));
//            }
        }else if (update.getMessage().getText().equals("/start")){
            String id = update.getMessage().getFrom().getId().toString();


            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
            sendMessage.setText("assalomu alaykum");
            sendMessage.setReplyMarkup(buttonUtils.markup());
            sendMsg(sendMessage);

            authentication.begin();
            userService.createUser(id, update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getLastName(), update.getMessage().getFrom().getUserName());
            authentication.end();


        }
//        else if (update.getMessage().getText().equals("Руский")){
//            sendMessage.setText("Здравствуйте");
//            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
//            authentication.begin();
//            foodService.addFood(update.getMessage().getText());
//            authentication.end();
//            sendMessage.setReplyMarkup(buttonUtils.markup());
//            sendMsg(sendMessage);
//        }else if (update.getMessage().getText().equals("Узбекский")){
//            authentication.begin();
//            for (Foods test : foodService.getFood()){
//
//                sendMessage.setText("Assalomu alaykum " +
//                        "fayillar " + test.getId());
//                sendMessage.setReplyMarkup(keybord.markups());
//                sendMsg(sendMessage);
//            }
//            authentication.end();
//
//        }
//
//      sendMsg(utils.message(update.getMessage().getText(), update.getMessage().getChatId().toString()));


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

}
