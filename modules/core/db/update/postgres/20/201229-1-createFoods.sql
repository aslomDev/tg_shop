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
    FILE_BYTE bytea,
    --
    primary key (ID)
);