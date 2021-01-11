alter table TELEGRAMSHOP_FOODS rename column file_byte to file_byte__u63927 ;
alter table TELEGRAMSHOP_FOODS add column TYPE_ID uuid ;
alter table TELEGRAMSHOP_FOODS add column FILE_ID uuid ;
