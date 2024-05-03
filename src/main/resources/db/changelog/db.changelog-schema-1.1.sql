--liquibase formatted sql
--changeset Viktor_Marchuk:1

alter table cargo.loading
add column contact varchar(350)