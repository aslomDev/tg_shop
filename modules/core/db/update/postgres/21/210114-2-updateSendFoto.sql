alter table TELEGRAMSHOP_SEND_FOTO rename column deleted_by to deleted_by__u93901 ;
alter table TELEGRAMSHOP_SEND_FOTO rename column delete_ts to delete_ts__u41843 ;
alter table TELEGRAMSHOP_SEND_FOTO rename column updated_by to updated_by__u73074 ;
alter table TELEGRAMSHOP_SEND_FOTO rename column update_ts to update_ts__u77054 ;
alter table TELEGRAMSHOP_SEND_FOTO rename column created_by to created_by__u73192 ;
alter table TELEGRAMSHOP_SEND_FOTO rename column create_ts to create_ts__u58453 ;
alter table TELEGRAMSHOP_SEND_FOTO rename column version to version__u37768 ;
alter table TELEGRAMSHOP_SEND_FOTO alter column version__u37768 drop not null ;
