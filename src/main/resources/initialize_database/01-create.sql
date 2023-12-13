-- Data types
create type tp_role as enum (
	'CAVALEIRO',
	'DUQUE',
	'CONSELHEIRO',
	'MONARCA'
);

create type tp_forum as enum (
	'LIVRE',
	'ESTUDOS',
	'PAINEL_ESCRIBAS',
	'AVISOS'
);

create cast (varchar as tp_role) with inout as implicit;
create cast (varchar as tp_forum) with inout as implicit;

-- Tables
create table TB_ACCOUNT (
    id_account INT not null primary key,
    username VARCHAR(30) not null,
    registration VARCHAR(9) not null,
    email VARCHAR(50) not null unique,
    fiefdom VARCHAR(30) not null,
    password VARCHAR(100) not null,
    tp_role tp_role not null
);

create table TB_FORUM (
    id_forum INT not null primary key,
    tp_forum tp_forum not null
);

create table TB_POST (
    id_post INT not null primary key,
    dh_created TIMESTAMP not null,
    tx_text TEXT not null,
    title VARCHAR(30) not null,
    id_forum INT not null,
    id_account INT not null,
    foreign key (id_forum)
    	references TB_FORUM (id_forum),
 	foreign key (id_account)
    	references TB_ACCOUNT (id_account)
);

create table TB_COMMENT (
    id_comment INT not null primary key,
    text VARCHAR(300) not null,
    dh_created TIMESTAMP not null,
    id_account INT not null,
    id_post INT not null,
    foreign key (id_account)
    	references TB_ACCOUNT (id_account),
 	foreign key (id_post)
    	references TB_POST (id_post)
);

create sequence sq_account increment by 1 minvalue 1 maxvalue 99999999 owned by tb_account.id_account;
create sequence sq_comment increment by 1 minvalue 1 maxvalue 99999999 owned by tb_comment.id_comment;
create sequence sq_post increment by 1 minvalue 1 maxvalue 99999999 owned by tb_post.id_post;
create sequence sq_forum increment by 1 minvalue 1 maxvalue 99999999 owned by tb_forum.id_forum;
