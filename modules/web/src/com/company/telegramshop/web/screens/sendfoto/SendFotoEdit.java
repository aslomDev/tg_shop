package com.company.telegramshop.web.screens.sendfoto;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegramshop.entity.SendFoto;

@UiController("telegramshop_SendFoto.edit")
@UiDescriptor("send-foto-edit.xml")
@EditedEntityContainer("sendFotoDc")
@LoadDataBeforeShow
public class SendFotoEdit extends StandardEditor<SendFoto> {
}