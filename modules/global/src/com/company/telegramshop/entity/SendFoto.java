package com.company.telegramshop.entity;

import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "TELEGRAMSHOP_SEND_FOTO")
@Entity(name = "telegramshop_SendFoto")
public class SendFoto extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 2139719539667251895L;

    @Column(name = "NAME")
    private String name;

    private @JoinColumn(name = "file_id")
    @ManyToOne(fetch = FetchType.LAZY)
    List<FileDescriptor> files;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_MSG_ID")
    private User user;

    public SendFoto(String name, List<FileDescriptor> files, User user) {
        this.name = name;
        this.files = files;
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

    public List<FileDescriptor> getFiles() {
        return files;
    }

    public void setFiles(List<FileDescriptor> files) {
        this.files = files;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}