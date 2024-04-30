drop table if exists Booking;
create table if not exists Booking
(
    id        int auto_increment,
    film      varchar(255) NOT NULL,
    antall    int          NOT NULL,
    fornavn   varchar(255) NOT NULL,
    etternavn varchar(255) NOT NULL,
    telefonnr int          NOT NULL,
    epost     varchar(255) NOT NULL
);

insert into Booking(id, film, antall, fornavn, etternavn, telefonnr, epost)
values (0, 'Spiderman', 1, 'Olav', 'Sverre', 12345678, 'Olav@epost.no')