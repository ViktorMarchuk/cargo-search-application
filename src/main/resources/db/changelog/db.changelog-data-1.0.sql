--liquibase formatted sql
--changeset Viktor_Marchuk:1

insert into cargo.country(name_country)
select unnest(array['BY', 'LT', 'PL', 'DE', 'DK', 'CZ', 'F', 'GB'])
where not exists (select 1 from cargo.country where name_country = any(array['BY', 'LT', 'PL', 'DE', 'DK', 'CZ', 'F', 'GB']));



insert into cargo.city(name_city, country_id)
select 'Minsk', id from cargo.country where name_country = 'BY' union all
select 'Brest', id from cargo.country where name_country = 'BY' union all
select 'Grodno', id from cargo.country where name_country = 'BY' union all
select 'Vilnius', id from cargo.country where name_country = 'LT' union all
select 'Kaunas', id from cargo.country where name_country = 'LT' union all
select 'Klaypeda', id from cargo.country where name_country = 'LT' union all
select 'Berlin', id from cargo.country where name_country = 'DE' union all
select 'Hamburg', id from cargo.country where name_country = 'DE' union all
select 'Dresden', id from cargo.country where name_country = 'DE' union all
select 'Kopenhagen', id from cargo.country where name_country = 'DK' union all
select 'Odense', id from cargo.country where name_country = 'DK' union all
select 'Warsawa', id from cargo.country where name_country = 'PL' union all
select 'Lodz', id from cargo.country where name_country = 'PL' union all
select 'Kielce', id from cargo.country where name_country = 'PL' union all
select 'Praga', id from cargo.country where name_country = 'CZ' union all
select 'Ostrava', id from cargo.country where name_country = 'CZ' union all
select 'Paris', id from cargo.country where name_country = 'F' union all
select 'Lion', id from cargo.country where name_country = 'F' union all
select 'London', id from cargo.country where name_country = 'GB' union all
select 'Dover', id from cargo.country where name_country = 'GB';


insert into cargo.kind_of_transport(kind_transport)
values ('Tilt'),
       ('Ref'),
       ('Platform'),
       ('Tilt 120 m3');

insert into cargo.loading(loading_date, country_load_id, city_name_load_id, country_unload_id, city_name_unload_id,
                          kind_of_transport_id, name_of_load, price)
values ('2024-03-26', 1, 1, 2, 4, 1, 'plastic on pallets', 1250),
       ('2024-03-30', 4, 7, 3, 12, 2, 'Meat ,temp -18', 2540),
       ('2024-04-01', 2, 5, 3, 12, 4, 'Izolation on pallets', 1800);