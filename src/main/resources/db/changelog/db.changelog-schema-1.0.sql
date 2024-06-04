--liquibase formatted sql
--changeset Viktor_Marchuk:1

create table if not exists cargo.country
(
    id           serial primary key,
    name_country varchar(56) not null unique
);

create table if not exists cargo.kind_of_transport
(
    id             serial primary key,
    kind_transport varchar(56) not null unique
);

create table if not exists cargo.city
(
    id        serial primary key,
    name_city varchar(120) not null unique
);

create table if not exists cargo.contact
(
    id           serial primary key,
    company_name varchar(50),
    address      varchar(150),
    email        varchar(100),
    telephone    varchar(100),
    contact_name varchar(60),
    password     varchar(100)
);

create table if not exists cargo.loading
(
    id                   bigserial primary key,
    loading_date         Date,
    country_load_id      int references cargo.country (id) on DELETE cascade,
    city_name_load_id    int references cargo.city (id) on DELETE cascade,
    country_unload_id    int references cargo.country (id) on DELETE cascade,
    city_name_unload_id  int references cargo.city (id) on DELETE cascade,
    kind_of_transport_id int references cargo.kind_of_transport (id) on DELETE cascade,
    name_of_load         varchar(200),
    price                int,
    contact_id           int references cargo.contact (id) on DELETE cascade
);

