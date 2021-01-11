package com.company.telegramshop.service;

import com.company.telegramshop.entity.SendFoto;
import com.haulmont.cuba.core.entity.FileDescriptor;

import java.awt.print.Pageable;

public interface UserService {
    String NAME = "telegramshop_UserService";

    void createUser(String id, String firstName, String lastName, String userName);
    void sendFoto(String id, String name, FileDescriptor file);
//    SendFoto send(Pageable pageable);
}