package com.company.telegramshop.service;

import com.company.telegramshop.config.TgConfig;
import com.company.telegramshop.entity.SendFoto;
import com.company.telegramshop.entity.User;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import javax.inject.Inject;
import java.awt.print.Pageable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

@Service(UserService.NAME)
public class UserServiceBean implements UserService {
    @Inject
    private Metadata metadata;
    @Inject private Persistence persistence;
    @Inject private TgConfig tgConfig;

    @Inject
    Authentication authentication;

    @Override
    public void createUser(String id, String firstName, String lastName, String userName) {
        Transaction tx = persistence.createTransaction();
        try {
            if (getUserId(id) != null){
                System.out.println("user mavjud!");
            }else {
                EntityManager em = persistence.getEntityManager();
                User tgUser = metadata.create(User.class);
                tgUser.setUserId(id);
                tgUser.setFirstName(firstName);
                tgUser.setLastName(lastName);
                tgUser.setUserName(userName);
                em.persist(tgUser);
                tx.commit();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            tx.end();
        }
    }

    @Override
    public void sendFoto(String id, String name, FileDescriptor file) {
        Transaction tx = persistence.createTransaction();
        try {
            if (getUserId(id) != null){
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(id);
                sendPhoto.setCaption(name);
                File dir = new File(String.valueOf(file));


                File rd = new File("C:\\Users\\Аслом\\almSoft\\osgo_api\\telegramshop\\modules\\core\\src\\com\\company\\telegramshop\\img\\test.png");

                InputFile inputFile = new InputFile();
                inputFile.setMedia(dir.getAbsoluteFile());
                File files = new File(String.valueOf(file));


                authentication.begin();
//                System.out.println("filellar " + dir.toPath());
                dir.mkdirs();
//                System.out.println("input " + inputFile);
//                System.out.println("files " + files.getPath());
//                System.out.println("file ozi " + file.toString());
               sendPhoto.setPhoto(inputFile);
                tgConfig.sendPhoto(sendPhoto);
                authentication.end();
                tx.commit();

            } else {
                System.out.println("not found user");
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            tx.end();
        }
    }

//    @Override
//    public SendFoto send(Pageable pageable) {
//        return getSendFotoPageable(pageable);
//    }


    public User getUserId(String id) {
        Transaction tx = persistence.createTransaction();
        try {
            TypedQuery<User> queryA = persistence.getEntityManager()
                    .createQuery("select s from telegramshop_User s where s.userId = :userId", User.class);
            queryA.setParameter("userId", id);
            return queryA.getFirstResult();
        } finally {
            tx.end();
        }
    }

//    public SendFoto getSendFotoPageable (Pageable pageable) {
//        SendFoto sendFoto;
//        Transaction tx = persistence.createTransaction();
//        try {
//            TypedQuery<SendFoto> query = persistence.getEntityManager().createQuery(
//                    "select t from paycom_Method t", SendFoto.class);
//            query.setParameter(2, pageable);
//            sendFoto = query.getSingleResult();
//            tx.commit();
//        } finally {
//            tx.end();
//        }
//        return sendFoto;
//    }
}