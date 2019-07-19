create table USER_TB (
userid VARCHAR(20) NOT NULL
constraint USER_TB_PK primary key ,
password VARCHAR(40) NOT NULL

);

create table BOOK_TB (
    isbn VARCHAR(30) NOT NULL
    constraint BOOK_TB_PK primary key,
title VARCHAR(30),
image BLOB,
description VARCHAR(200),
writer VARCHAR(50),
publisher VARCHAR(50),
publicationdate DATE ,
price VARCHAR(20),
saleprice VARCHAR(20)
);
