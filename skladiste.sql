drop database if exists skladiste;
create database skladiste default character set utf8;
use skladiste;

create table proizvod(
    id int not null primary key auto_increment,
    naziv varchar(50) not null,
    cijena decimal(18,2),
    kolicina int,
    proizvodac_id int not null,
    dobavljac_id int not null
);

create table proizvodac(
    id int not null primary key auto_increment,
    naziv varchar(50) not null,
    adresa varchar(100) not null,
    kontakt varchar(50),
    email varchar(100)
);

create table dobavljac(
    id int not null primary key auto_increment,
    naziv varchar(50) not null,
    adresa varchar(100) not null,
    kontakt varchar(50),
    email varchar(100)
);

create table proizvod_narudzba(
    proizvod_id int not null,
    narudzba_id int not null
);

create table narudzba(
    id int not null primary key auto_increment,
    datum datetime not null,
    zaposlenik_id int not null
);

create table zaposlenik(
    id int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    kontakt varchar(50) not null,
    email varchar(100) not null
);

alter table proizvod add foreign key (proizvodac_id) references proizvodac(id);
alter table proizvod add foreign key (dobavljac_id) references dobavljac(id);

alter table proizvod_narudzba add foreign key (proizvod_id) references proizvod(id);
alter table proizvod_narudzba add foreign key (narudzba_id) references narudzba(id);

alter table narudzba add foreign key (zaposlenik_id) references zaposlenik(id);

insert into proizvodac(naziv, adresa, kontakt) values('Intel','2200 Mission College Blvd. Santa Clara, CA  95052 USA', '(408) 765-8080');
insert into proizvodac(naziv, adresa, kontakt) values('AMD','One AMD Place P.O. Box 3453 Sunnyvale, CA 94088', '(408) 749-3060');

insert into dobavljac(naziv, adresa, kontakt, email) values('Pevec d.o.o.', 'Kišpatićeva 83', '032520694', 'pevec@pevec.hr');
insert into dobavljac(naziv, adresa, kontakt, email) values('Centar tehnike d.o.o.', 'Crkvena 23', '031635789', 'ctehnike@ctehnike.hr');

insert into proizvod(naziv, cijena, kolicina, proizvodac_id, dobavljac_id) values('i5', 2100.99, 5, 1, 1);
insert into proizvod(naziv, cijena, kolicina, proizvodac_id, dobavljac_id) values('Ryzen 5', 1520.99, 3, 2, 2);


insert into zaposlenik(ime, prezime, kontakt, email) values('Ante', 'Antić', '092569724', 'ante@antic.hr');
insert into zaposlenik(ime, prezime, kontakt, email) values('Josip', 'Josić', '091359621', 'josip@josic.hr');

insert into narudzba(datum, zaposlenik_id) values('2019-05-06', 1);
insert into narudzba(datum, zaposlenik_id) values('2019-07-16', 2);