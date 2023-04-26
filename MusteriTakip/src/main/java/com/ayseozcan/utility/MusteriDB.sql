create table tblmusteri(
    id bigserial primary key,
    ad varchar(100),
    adres varchar(250),
    telefon varchar(20),
    avatar varchar(255),
    state int default 1
)
create table tbluser(
    id bigserial primary key,
    username varchar(32),
    pwd varchar(64),
    email varchar(200),
    isadmin boolean default false    
)