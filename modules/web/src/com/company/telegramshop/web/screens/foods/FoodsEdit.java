package com.company.telegramshop.web.screens.foods;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegramshop.entity.Foods;

@UiController("telegramshop_Foods.edit")
@UiDescriptor("foods-edit.xml")
@EditedEntityContainer("foodsDc")
@LoadDataBeforeShow
public class FoodsEdit extends StandardEditor<Foods> {
}