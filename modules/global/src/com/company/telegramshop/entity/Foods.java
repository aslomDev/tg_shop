package com.company.telegramshop.entity;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "TELEGRAMSHOP_FOODS")
@Entity(name = "telegramshop_Foods")
public class Foods extends StandardEntity {
    private static final long serialVersionUID = 1978471290473646093L;

    @Column(name = "FOOD_NAME")
    private String foodName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FILESIZE")
    private Long fileSize;

    private @JoinColumn(name = "file_id")
    @ManyToOne(fetch = FetchType.LAZY)
    FileDescriptor file;


    public Foods() {
    }

    public Foods(String foodName, String name, Long fileSize, FileDescriptor file) {
        this.foodName = foodName;
        this.name = name;
        this.fileSize = fileSize;
        this.file = file;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public FileDescriptor getFile() {
        return file;
    }

    public void setFile(FileDescriptor file) {
        this.file = file;
    }
}