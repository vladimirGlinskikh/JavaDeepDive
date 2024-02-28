DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;

CREATE TABLE person
(
    personId  INTEGER primary key,
    lastName  VARCHAR(50),
    firstName VARCHAR(50)
);

CREATE TABLE address
(
    addressId INTEGER primary key,
    personId  INTEGER,
    city      VARCHAR(50),
    state     VARCHAR(30)
);

INSERT INTO person(personId, lastName, firstName)
VALUES (1, 'Wang', 'Allen'),
       (2, 'Alice', 'Bob');

INSERT INTO address(addressId, personId, city, state)
VALUES (1, 2, 'New York City', 'New York'),
       (2, 3, 'Leetcode', 'California');

SELECT p.lastName, p.firstName, a.city, a.state
FROM person p
         LEFT JOIN address a ON p.personId = a.personId;