package com.company.telegramshop.config.utills;

import com.company.telegramshop.service.UserService;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.inject.Inject;

@Component
public class CommandText {
    @Inject
    Authentication authentication;
    @Inject private UserService userService;
    @Inject private ButtonUtils buttonUtils;

    SendMessage sendMessage = new SendMessage();
    EditMessageText editMessageText = new EditMessageText();


    public SendMessage start(Update update){
        String id = update.getMessage().getFrom().getId().toString();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText("assalomu alaykum");
        sendMessage.setReplyMarkup(buttonUtils.markup());

        /// create User
        authentication.begin();
        userService.createUser(id, update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getLastName(), update.getMessage().getFrom().getUserName());
        authentication.end();

        return sendMessage;
    }


    public EditMessageText lang(Update update){
        Message message = update.getCallbackQuery().getMessage();
            editMessageText.setText("salom menu");
            editMessageText.setChatId(String.valueOf(message.getChatId()));
            editMessageText.setMessageId(message.getMessageId());
            editMessageText.setReplyMarkup(buttonUtils.oziqMarkup());
            return editMessageText;


    }


}
