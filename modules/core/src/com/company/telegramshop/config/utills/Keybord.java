package com.company.telegramshop.config.utills;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.LinkedList;
import java.util.List;

@Component
public class Keybord {

    public KeyboardRow keyboardRow(){
        KeyboardRow rows = new KeyboardRow();
        rows.add("Руский");
        rows.add("Узбекский");
        return rows;
    }

    public List<KeyboardRow> rowList(){
        List<KeyboardRow> keyboardRows = new LinkedList<>();
        keyboardRows.add(keyboardRow());
        return keyboardRows;
    }

    public ReplyKeyboardMarkup markup(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList());
        return replyKeyboardMarkup;
    }


    ///

    public KeyboardRow keyboardRows(){
        KeyboardRow rows = new KeyboardRow();
        rows.add("test");
        return rows;
    }

    public List<KeyboardRow> rowLists(){
        List<KeyboardRow> keyboardRows = new LinkedList<>();
        keyboardRows.add(keyboardRows());
        return keyboardRows;
    }

    public ReplyKeyboardMarkup markups(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowLists());
        return replyKeyboardMarkup;
    }

    ///






    ///



    public boolean markupRemove(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList());
        return replyKeyboardMarkup.getKeyboard().remove(replyKeyboardMarkup);
    }





}
