drop database if exists aula;
create database aula;
use aula;

create table produto(
    idproduto           integer         auto_increment      primary key,
    nome                varchar(35)     not null,
    marca               varchar(25)     not null
);

create table estoque(
    idestoque           integer         auto_increment      primary key,
    descricao           text            not null
);

create table lote(
    idproduto           integer         not null,
    idestoque           integer         not null
);

alter table lote add constraint fk_produto foreign key(idproduto) references produto(idproduto);
alter table lote add constraint fk_estoque foreign key(idestoque) references estoque(idestoque);


insert into produto(nome,marca) values('Notebook','HP');
insert into produto(nome,marca) values('Monitor','LG');
insert into produto(nome,marca) values('Mouse','Microsoft');
insert into produto(nome,marca) values('Teclado','Microsoft');

select * from produto;

