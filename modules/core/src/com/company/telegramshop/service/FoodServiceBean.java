package com.company.telegramshop.service;

import com.company.telegramshop.config.TgConfig;
import com.company.telegramshop.entity.Foods;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.app.FileStorageService;
import com.haulmont.cuba.core.app.filestorage.FileStorage;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

@Service(FoodService.NAME)
public class FoodServiceBean implements FoodService {
    @Inject private Metadata metadata;
    @Inject private Persistence persistence;
    @Inject private TgConfig tgConfig;
    @Inject private FileStorageService fileStorageService;

    @Override
    public List<Foods> getFood() {
            List<Foods> foods;
            Transaction tx = persistence.createTransaction();
            try {
                TypedQuery<Foods> queryA = persistence.getEntityManager().createQuery(
                        "select s from telegramshop_Foods s", Foods.class);
                foods = queryA.getResultList();
                tx.commit();
            } finally {
                tx.end();
            }
            return foods;
        }

    @Override
    public void addFood(String name) {
        Transaction tx = persistence.createTransaction();

        try {

            EntityManager em = persistence.getEntityManager();
            Foods foods = metadata.create(Foods.class);
            foods.setFoodName(name);
//            foods.setFile(fileDescriptor);
            em.persist(foods);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            tx.end();
        }
    }

    @Override
    public void sendPhoto(UUID id, FileDescriptor file) {
        Transaction tx = persistence.createTransaction();
        try {
            if (getFoodId(id) != null){
                SendPhoto sendPhoto = new SendPhoto();
                for (Foods foods : getFood()){
                   InputFile file2 = new InputFile(String.valueOf(foods.getFile()));
                   sendPhoto.setPhoto(file2);
                    tgConfig.sendPhoto(sendPhoto);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            tx.end();
        }


    }

    public Foods getFoodId(UUID id) {
        Transaction tx = persistence.createTransaction();
        try {
            TypedQuery<Foods> queryA = persistence.getEntityManager()
                    .createQuery("select s from playmobile_TgUser s where s.Id = :Id", Foods.class);
            queryA.setParameter("Id", id);
            return queryA.getFirstResult();
        } finally {
            tx.end();
        }
    }

}