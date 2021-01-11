alter table TELEGRAMSHOP_FOODS add constraint FK_TELEGRAMSHOP_FOODS_ON_TYPE foreign key (TYPE_ID) references attachment_type(ID);
create index IDX_TELEGRAMSHOP_FOODS_ON_TYPE on TELEGRAMSHOP_FOODS (TYPE_ID);
