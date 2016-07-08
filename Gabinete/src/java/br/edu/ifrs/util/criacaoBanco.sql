/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Portal
 * Created: 05/07/2016
 */

--EvertonQuadros
--aviso a execução desse script impede que o módulo de login funcione corretamente, provavelmente o projeto inteiro.

create database trabalho_gabinete

drop table espacos;

create table espacos
(
  numero int not null,
  nome varchar(255),
  descricao text,
  lotacao int,
  tipo varchar(15),
  projetor boolean,
  internet boolean,
  quadro boolean,
  especialidade varchar(100),
  equipamentos text,
  situacao varchar(45),
  primary key (numero)
);


insert into espacos values(400,'ola','descriçao',30,'sala de aula',true,false,true,'computação','computadores','ativo');

insert into espacos values(401,'ola1','descriçao',30,'Laboratorio',true,false,true,'computação','computadores','inativo');

insert into espacos values(402,'ola2','descriçao',30,'laboratorio',true,false,true,'computação','computadores','ativo');

insert into espacos values(403,'ola3','descriçao',30,'sala de aula',true,false,true,'computação','computadores','ativo');

select * from espacos;