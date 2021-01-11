package com.company.telegramshop.entity;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "TELEGRAMSHOP_SEND_FOTO")
@Entity(name = "telegramshop_SendFoto")
public class SendFoto extends StandardEntity {
    private static final long serialVersionUID = 2139719539667251895L;

    @Column(name = "NAME")
    private String name;

    private @JoinColumn(name = "file_id")
    @ManyToOne(fetch = FetchType.LAZY)
    FileDescriptor file;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_MSG_ID")
    private User user;

    public SendFoto() {
    }

    public SendFoto(String name, FileDescriptor file, User user) {
        this.name = name;
        this.file = file;
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileDescriptor getFile() {
        return file;
    }

    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}