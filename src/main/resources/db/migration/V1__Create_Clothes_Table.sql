CREATE TABLE if not exists clothes (
    id integer,
    type varchar(250),
    name varchar(250),
    price integer,
    created_at timestamp,
    updated_at timestamp,
    PRIMARY KEY (id)
    );