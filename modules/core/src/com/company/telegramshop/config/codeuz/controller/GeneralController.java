package com.company.telegramshop.config.codeuz.controller;

import com.company.telegramshop.config.codeuz.dto.CodeMessage;
import com.company.telegramshop.config.codeuz.enums.CodeMessageType;
import com.company.telegramshop.config.codeuz.util.InlineButtonUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;


public class GeneralController {


    public SendMessage handle(String text, Long chatId, Integer messageId) {

        CodeMessage codeMessage = new CodeMessage();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));

        codeMessage.setSendMessage(sendMessage);

        if (text.equals("/start")) {

            sendMessage.setText("Assalomu alaykum *TodoList* botiga xush kelibsiz.");
            sendMessage.setParseMode("Markdown");

            sendMessage.setReplyMarkup(InlineButtonUtil.keyboard(
                    InlineButtonUtil.collection(
                            InlineButtonUtil.row(InlineButtonUtil.button("Go to Menu", "menu"))
                    )));
            codeMessage.setType(CodeMessageType.MESSAGE);

        } else if (text.equals("/help")) {

            String msg = "*TodoList* Yordam oynasi.\n Siz bu bo'tda qilish kerak bo'lgna islariz jadvalini tuzishingiz mumkin.\n" +
                    "malumot uchun videoni [inline URL](https://www.youtube.com/channel/UCFoy0KOV9sihL61PJSh7x1g)  ko'ring.\n"
                    + "Yokiy manabu videoni ko'ring ";
            sendMessage.setText(msg);
            sendMessage.setParseMode("Markdown");
            sendMessage.disableWebPagePreview();

            SendVideo sendVideo = new SendVideo();
//            sendVideo.setVideo();
            sendVideo.setChatId(String.valueOf(chatId));
            sendVideo.setCaption("Bu video siz uhun juda muxim");
            sendVideo.setParseMode("HTML");

            codeMessage.setSendVideo(sendVideo);

            codeMessage.setSendMessage(sendMessage);
            codeMessage.setType(CodeMessageType.MESSAGE_VIDEO);


        } else if (text.equals("/setting")) {
            sendMessage.setText("Settinglar xali mavjut emas");
            sendMessage.setParseMode("Markdown");
            codeMessage.setType(CodeMessageType.MESSAGE);
        } else if (text.equals("menu")) {
            EditMessageText editMessageText = new EditMessageText();

            editMessageText.setText("*Assosiy Menu*");
            editMessageText.setChatId(String.valueOf(chatId));
            editMessageText.setMessageId(messageId);
            editMessageText.setParseMode("Markdown");

            editMessageText.setReplyMarkup(InlineButtonUtil.keyboard(
                    InlineButtonUtil.collection(
                            InlineButtonUtil.row(InlineButtonUtil.button("ToDo List", "/todo/list", ":clipboard:")),
                            InlineButtonUtil.row(InlineButtonUtil.button("Create New", "/todo/create", ":heavy_plus_sign:"))
                    )));

            codeMessage.setType(CodeMessageType.EDIT);
            codeMessage.setEditMessageText(editMessageText);
        }


        return codeMessage;
    }

}
