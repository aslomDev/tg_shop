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
);