package com.company.telegramshop.service;

import com.company.telegramshop.entity.Foods;
import com.haulmont.cuba.core.entity.FileDescriptor;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.util.List;
import java.util.UUID;

public interface FoodService {
    String NAME = "telegramshop_FoodService";

     List<Foods> getFood();

     void addFood(String name);

     void sendPhoto(UUID id, FileDescriptor file);

}