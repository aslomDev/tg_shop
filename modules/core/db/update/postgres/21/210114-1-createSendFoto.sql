create table TELEGRAMSHOP_SEND_FOTO (
    ID integer,
    --
    NAME varchar(255),
    file_id uuid,
    USER_MSG_ID uuid not null,
    --
    primary key (ID)
);