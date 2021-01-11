package com.company.telegramshop.web.screens.sendfoto;

import com.company.telegramshop.service.UserService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.telegramshop.entity.SendFoto;
import com.haulmont.cuba.gui.screen.LookupComponent;
import org.slf4j.Logger;

import javax.inject.Inject;

import static jdk.nashorn.internal.codegen.OptimisticTypesPersistence.load;

@UiController("telegramshop_SendFoto.browse")
@UiDescriptor("send-foto-browse.xml")
@LookupComponent("sendFotoesTable")
@LoadDataBeforeShow
public class SendFotoBrowse extends StandardLookup<SendFoto> {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SendFotoBrowse.class);
    @Inject private UserService userService;
    @Inject
    private CollectionLoader<SendFoto> sendFotoesDl;

    @Inject
    protected UiComponents uiComponents;
    @Inject
    private GroupTable<SendFoto> sendFotoesTable;
    @Inject
    private CollectionContainer<SendFoto> sendFotoesDc;

//    @Inject private GroupTable<SendFoto> sendFotoGroupTable;

    @Inject
    private DataManager dataManager;

    @Subscribe("sendBtn")
    public void onSendBtnClick(Button.ClickEvent event) {
        FileDescriptor fileDescriptor = sendFotoesDc.getItem().getFile();


        Image image = smallAvatarImage();
        image.setSource(FileDescriptorResource.class)
                .setFileDescriptor(fileDescriptor);

//        dataManager.secure(load(sendFotoesTable.getSingleSelected().getFile());

        System.out.println("filedesc " +  sendFotoesTable.getSingleSelected().getFile());


        userService.sendFoto(sendFotoesDl.getContainer().getItem().getUser().getUserId(), sendFotoesDl.getContainer().getItem().getName(), fileDescriptor );
//        System.out.println(renderAvatarImageComponent(sendFotoesDc.getItem()));
//        FileDescriptor fileDescriptor = sendFotoesDc.getItem().getFile();
//        System.out.println("test " +fileDescriptor);
    }


    @Subscribe
    protected void onInit(InitEvent event) {
        sendFotoesTable.addGeneratedColumn(
                "file",
                this::renderAvatarImageComponent
        );
    }

    private Component renderAvatarImageComponent(SendFoto sendFoto) {
        FileDescriptor imageFile = sendFoto.getFile();

        if (imageFile == null) {
            return null;
        }

        Image image = smallAvatarImage();
        image.setSource(FileDescriptorResource.class)
                .setFileDescriptor(imageFile);

        return image;
    }

    private Image smallAvatarImage() {
        Image image = uiComponents.create(Image.class);
        image.setScaleMode(Image.ScaleMode.CONTAIN);
        image.setHeight("40");
        image.setWidth("40");
        image.setStyleName("avatar-icon-small");
        return image;
    }



    



}