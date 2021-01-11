create table attachment_type (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    name varchar(500),
    code varchar(200),
    attachment_type_comment varchar(1000),
    isdefault boolean,
    issystem boolean,
    --
    primary key (ID)
);