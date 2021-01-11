package com.company.telegramshop.web.screens.user;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegramshop.entity.User;

@UiController("telegramshop_User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@LoadDataBeforeShow
public class UserBrowse extends StandardLookup<User> {
}