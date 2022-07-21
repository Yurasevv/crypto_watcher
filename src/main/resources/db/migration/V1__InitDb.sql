create table coin (
    id int8 not null,
    price_usd numeric(19, 2),
    symbol varchar(255),
    primary key (id)
);

create table usr (
    id int8 not null,
    crypto_price numeric(19, 2),
    crypto_symbol varchar(255),
    username varchar(255),
    primary key (id)
);
