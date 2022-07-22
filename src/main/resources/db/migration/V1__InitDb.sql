create table coin (
    id int8 not null,
    price decimal(12, 2),
    symbol varchar(32) not null,
    primary key (id)
);

create table usr (
    id int8 not null,
    crypto_price decimal(12, 2),
    crypto_symbol varchar(32) not null,
    username varchar(255) not null,
    primary key (id)
);
