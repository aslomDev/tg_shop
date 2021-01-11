package com.company.telegramshop.web.screens.foods;

import com.company.telegramshop.service.FoodService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.telegramshop.entity.Foods;

import javax.inject.Inject;

@UiController("telegramshop_Foods.browse")
@UiDescriptor("foods-browse.xml")
@LookupComponent("foodsesTable")
@LoadDataBeforeShow
public class FoodsBrowse extends StandardLookup<Foods> {
    @Inject private FoodService foodService;




}