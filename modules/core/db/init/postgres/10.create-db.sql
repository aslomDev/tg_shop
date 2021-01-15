-- begin TELEGRAMSHOP_FOODS
create table TELEGRAMSHOP_FOODS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FOOD_NAME varchar(255),
    NAME varchar(255),
    FILESIZE bigint,
    file_id uuid,
    --
    primary key (ID)
)^
-- end TELEGRAMSHOP_FOODS
-- begin TELEGRAMSHOP_USER
create table TELEGRAMSHOP_USER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    lastName varchar(255),
    firstName varchar(255),
    userName varchar(255),
    userId varchar(255),
    --
    primary key (ID)
)^
-- end TELEGRAMSHOP_USER
-- begin TELEGRAMSHOP_SEND_FOTO
create table TELEGRAMSHOP_SEND_FOTO (
    ID integer,
    --
    NAME varchar(255),
    file_id uuid,
    USER_MSG_ID uuid not null,
    --
    primary key (ID)
)^
-- end TELEGRAMSHOP_SEND_FOTO
