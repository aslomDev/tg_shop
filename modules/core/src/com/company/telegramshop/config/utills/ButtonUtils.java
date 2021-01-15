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


/////

    public InlineKeyboardButton key1(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("keyingisi");
        button.setCallbackData("keyin");
        return button;
    }


    public InlineKeyboardButton key2(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("oldingisi");
        button.setCallbackData("oldin");
        return button;
    }

    public List<InlineKeyboardButton> key3(){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(key1());
        row.add(key2());
        return row;
    }
    public List<List<InlineKeyboardButton>> key4(){
        List<List<InlineKeyboardButton>> rows = new LinkedList<>();
        rows.add(key3());
        return rows;
    }

    public InlineKeyboardMarkup keyMarkup(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(key4());
        return markup;
    }

    ////




    //// buttons

    public InlineKeyboardButton but1(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Next");
        button.setCallbackData("Image#" + 2);
        return button;
    }

    public InlineKeyboardButton but2(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Prev");
        button.setCallbackData("Image#" + 0);
        return button;
    }


    public List<InlineKeyboardButton> addBut(){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(but1());
        row.add(but2());
        return row;
    }

    public List<List<InlineKeyboardButton>> block(){
        List<List<InlineKeyboardButton>> rows = new LinkedList<>();
        rows.add(addBut());
        return rows;
    }


    public InlineKeyboardMarkup butMarkup(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(block());
        return markup;
    }


    ////


    ////edit Buttons

    public InlineKeyboardButton edBut1(String index){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Next");
        button.setCallbackData("Image#" +  (Integer.parseInt(index) + 1));
        return button;
    }

    public InlineKeyboardButton edBut2(String index){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Prev");
        button.setCallbackData("Image#" + (Integer.parseInt(index) - 1));
        return button;
    }

    public List<InlineKeyboardButton> addEdBut(String index){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(edBut1(index));
        row.add(edBut2(index));
        return row;
    }

    public List<List<InlineKeyboardButton>> edblock(String index){
        List<List<InlineKeyboardButton>> rows = new LinkedList<>();
        rows.add(addEdBut(index));
        return rows;
    }


    public InlineKeyboardMarkup edbutMarkup(String index){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(edblock(index));
        return markup;
    }

    /////




}
