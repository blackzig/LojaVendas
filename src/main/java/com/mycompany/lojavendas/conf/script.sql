/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Michel
 * Created: 23/01/2019
 */

create table categoria(
	id varchar(255) not null primary key,
	codigo varchar(255) not null,
	nome varchar(255) not null
);

create table produto(
	id varchar(255) not null primary key,
	codigo varchar(255) not null,
	nome varchar(255) not null,
	preco double(10,2) not null,
	quantidade int not null,
	id_categoria varchar(255) not null,
	foreign key(id_categoria) references categoria(id)
);

create table cliente(
	id varchar(255) not null primary key,
	nome varchar(255) not null,
	cpf varchar(255),
	nascimento DATE
);

/* Removi o horário da tabela pedido e escolhi o datetime o qual já guarda o dia e horário */
create table pedido(
	id varchar(255) not null primary key,
	numero int not null,
	data datetime not null,
	total double(10,2) not null,
	status varchar(255) not null,
	id_cliente varchar(255) not null,
	foreign key(id_cliente) references cliente(id)
);

create table item(
	id varchar(255) not null primary key,
	quantidade int not null,
	preco double(10,2) not null,
	id_produto varchar(255) not null,
	id_pedido varchar(255) not null,
	foreign key(id_produto) references produto(id),
	foreign key(id_pedido) references pedido(id)
);

create table usuario(
	id varchar(255) not null primary key,
	login varchar(255) not null,
	senha varchar(255) not null
);

create table tipo_usuario(
	id varchar(255) not null primary key,
	nome varchar(255) not null,
	id_usuario varchar(255) not null,
	foreign key(id_usuario) references usuario(id)
);