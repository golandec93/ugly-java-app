create table books(
    name        varchar NOT NULL,
    description text,
    author      varchar NOT NULL,
    page_count  integer,
    publisher   varchar NOT NULL,
    isbn13      char(13) PRIMARY KEY,
    isbn10      char(10),
    ocls        varchar
);

insert into books (name, description, author, page_count, publisher, isbn13, isbn10, ocls)
values ('1984', null, 'George Orwell', 336, 'Signet Classics', '9780451524935', '0451524934', '470015866');

insert into books (name, description, author, page_count, publisher, isbn13, isbn10)
values ('Clay Machine Gun', null, 'VICTOR PELEVIN', 200, 'Faber & Faber Ltd', '9780571201266', '0571201261');

insert into books (name, description, author, publisher, isbn13, isbn10)
values ('Harry Potter and the Prisoner of Azkaban', null, 'Rowling, J. K', 'Bloomsbury Publishing Plc', '9780747546290', '0747546290');

create table warehouse
(
    id           SERIAL PRIMARY KEY,
    name         varchar UNIQUE NOT NULL,
    address      text UNIQUE NOT NULL,
    workingHours varchar,
    managerName  varchar
);

insert into warehouse (name, address, workingHours, managerName)
values ('Bangalore, Ashok Nagar', 'BNG/ASHK/12ST,8CR/1243', '09:00-22:00', 'George Babu');

insert into warehouse (name, address, workingHours, managerName)
values ('Bangalore, Nagasandra', 'BNG/NGS/110FTRD/456', '10:00-20:00', 'Narendra Babu');


create table book_availability
(
    warehouse_id integer REFERENCES  warehouse(id),
    book_id char(13) REFERENCES books(isbn13),
    amount integer,
    PRIMARY KEY (warehouse_id, book_id)
);
insert into book_availability (warehouse_id, book_id, amount)
select id, '9780747546290' /* Harry Potter */ as book_id, 5 as amount  from warehouse where warehouse.name = 'Bangalore, Ashok Nagar';
;
insert into book_availability (warehouse_id, book_id, amount)
select id, '9780571201266' /* Clay Machine Gun */ as book_id, 1 as amount  from warehouse where warehouse.name = 'Bangalore, Ashok Nagar'
;
insert into book_availability (warehouse_id, book_id, amount)
select id, '9780451524935' /* 1984 */ as book_id, 1 as amount  from warehouse where warehouse.name = 'Bangalore, Ashok Nagar'
;
insert into book_availability (warehouse_id, book_id, amount)
select id, '9780571201266' /* Clay Machine Gun */ as book_id, 1 as amount  from warehouse where warehouse.name = 'Bangalore, Nagasandra'
;
insert into book_availability (warehouse_id, book_id, amount)
select id, '9780451524935' /* 1984 */ as book_id, 1 as amount  from warehouse where warehouse.name = 'Bangalore, Nagasandra'