package com.company.telegramshop.config.utills;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

@Component
public class ButtonUtils {

    public InlineKeyboardButton button(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Руский");
        button.setCallbackData("menuCalRus");
        return button;
    }

    public InlineKeyboardButton button2(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Узбекский");
        button.setCallbackData("menuCalUz");
        return button;
    }


    public List<InlineKeyboardButton> buttons(){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(button());
        row.add(button2());
        return row;
    }
    public List<List<InlineKeyboardButton>> buttonList(){
        List<List<InlineKeyboardButton>> rows = new LinkedList<>();
        rows.add(buttons());
        return rows;
    }

    public InlineKeyboardMarkup markup(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(buttonList());
        return markup;
    }


    /// foods

    public InlineKeyboardButton oziqOvqat(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("oziq ovqatlar");
        button.setCallbackData("food");
        return button;
    }


    public InlineKeyboardButton noOziqOvqat(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("no oziq ovqatlar");
        button.setCallbackData("noFood");
        return button;
    }

    public List<InlineKeyboardButton> oziqList(){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(oziqOvqat());
        row.add(noOziqOvqat());
        return row;
    }
    public List<List<InlineKeyboardButton>> oziqListt(){
        List<List<InlineKeyboardButton>> rows = new LinkedList<>();
        rows.add(oziqList());
        return rows;
    }

    public InlineKeyboardMarkup oziqMarkup(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(oziqListt());
        return markup;
    }


    ///







}
