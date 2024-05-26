create table person
(
    id    serial      not null primary key,
    email varchar(50) not null
);

insert into person(email)
values ('a@b.com'),
       ('c@d.com'),
       ('a@b.com');

select email
from person
group by email
having count(*) > 1;