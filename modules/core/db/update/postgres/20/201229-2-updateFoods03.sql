alter table TELEGRAMSHOP_FOODS rename column type_id to type_id__u62963 ;
alter table TELEGRAMSHOP_FOODS drop constraint FK_TELEGRAMSHOP_FOODS_ON_TYPE ;
drop index IDX_TELEGRAMSHOP_FOODS_ON_TYPE ;
