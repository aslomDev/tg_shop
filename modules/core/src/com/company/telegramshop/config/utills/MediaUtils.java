package com.company.telegramshop.config.utills;

import com.company.telegramshop.entity.SendFoto;
import com.company.telegramshop.service.UserService;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class MediaUtils {
    @Inject
    Authentication authentication;
    @Inject private UserService userService;
    @Inject private FileLoader fileLoader;
    @Inject private ButtonUtils buttonUtils;


    public SendMediaGroup photo(Update update) {
        SendPhoto sendPhoto = new SendPhoto();
        SendMediaGroup sendMediaGroup = new SendMediaGroup();
        SetChatPhoto setChatPhoto = new SetChatPhoto();
        Message message = update.getCallbackQuery().getMessage();


        authentication.begin();
        List<SendFoto> list = userService.getSendFotoPageable(4,4);
        List<InputMedia> inputMedia1 = new LinkedList<>();
        String data = update.getCallbackQuery().getData();

        for (SendFoto s : list){
            InputMediaPhoto inputMedia = new InputMediaPhoto();
            try {
                inputMedia.setMedia(fileLoader.openStream(s.getFile()), s.getFile().getName());
                inputMedia.setCaption(s.getName());
            } catch (FileStorageException e) {
                e.printStackTrace();
            }
            inputMedia1.add(inputMedia);
//            sendPhoto.setChatId(String.valueOf(message.getChatId()));
//            sendPhoto.setCaption(s.getName());
//            sendPhoto.setPhoto(inputMedia);
            sendMediaGroup.setChatId(message.getChatId().toString());
            sendMediaGroup.setMedias(inputMedia1);


        }

        sendPhoto.setReplyMarkup(buttonUtils.butMarkup());
        return sendMediaGroup;
    }

//    public SendMessage sendSubContent(Update update){
//        SendMessage sendMessage = new SendMessage();
//        Message message = update.getCallbackQuery().getMessage();
//        authentication.begin();
//        List<SendFoto> list = userService.getSendFotoPageable(4,4);
//        for (SendFoto s : list){
//            InputMediaPhoto inputMedia = new InputMediaPhoto();
//            try {
//                inputMedia.setCaption(s.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            sendMessage.setChatId(message.getChatId().toString());
//            sendMessage.setText();
//
//
//        }
//    }

    public EditMessageMedia edit(Update update){
        EditMessageMedia editMessageMedia = new EditMessageMedia();
        InputMediaPhoto inputMediaPhoto = new InputMediaPhoto();
        Message message = update.getCallbackQuery().getMessage();

        String data = update.getCallbackQuery().getData();
        int i = data.indexOf("#");
        String index = data.substring(i + 1);

        authentication.begin();
            List<SendFoto> list = userService.getSendFotoPageable(Integer.parseInt(index), Integer.parseInt(index));
            for (SendFoto s : list) {
                try {
                    inputMediaPhoto.setMedia(fileLoader.openStream(s.getFile()), s.getFile().getName());
                    inputMediaPhoto.setCaption(s.getName());
                } catch (FileStorageException e) {
                    e.printStackTrace();
                }
                editMessageMedia.setChatId(message.getChatId().toString());
                editMessageMedia.setInlineMessageId(update.getCallbackQuery().getInlineMessageId());
                editMessageMedia.setMessageId(message.getMessageId());
                editMessageMedia.setMedia(inputMediaPhoto);
            }
             editMessageMedia.setReplyMarkup(buttonUtils.edbutMarkup(index));
            return editMessageMedia;
    }
}
