package com.company.telegramshop.web.screens.user;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegramshop.entity.User;

@UiController("telegramshop_User.edit")
@UiDescriptor("user-edit.xml")
@EditedEntityContainer("userDc")
@LoadDataBeforeShow
public class UserEdit extends StandardEditor<User> {
}