/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Not275ssd
 * Created: 04/07/2016
 */

use gabinete;

insert into setores values(null,"Administração",0),
                          (null,"Assuntos Educacionais",0),
                          (null,"Ensino",0),
                          (null,"Tecnologia da Informação",0),
                          (null,"Biblioteca",0),
                          (null,"Assistência Estudantil",0),
                          (null,"Secretaria",0),
                          (null,"Auditoria",0),
                          (null,"Pedagogia",0),
                          (null,"Produção Cultural",0),
                          (null,"Reitoria",0),
                          (null,"Recursos Humanos",0),
                          (null,"Tesouraria",0),
                          (null,"Extensão e Pesquisa",0);

--1 - administrador, 0 - usuario padrao, 1 - recepcionista, 2 - gabinete, 3+ sevidores em geral

insert into usuarios values("joaod","joao123","12345678901","João Damasceno","1234-4321","ifrsRestinga@restinga.ifrs.edu.br",0,1234141,"IFRS RESTINGA",48,4),
                           ("administrador","admin123","12345678902","Luiza Gonzalez","1234-4312","ifrsRestinga2@restinga.ifrs.edu.br",-1,1234141,"IFRS RESTINGA",48,1),
                           ("user","user123","12345678903","Armando Nogueira","1234-4213","ifrsRestinga3@restinga.ifrs.edu.br",0,1234141,"IFRS RESTINGA",48,2),
                           ("recepcao","recepcao123","12345678904","Rui Barbosa","1234-1324","ifrsRestinga4@restinga.ifrs.edu.br",1,1234141,"IFRS RESTINGA",48,7),
                           ("gabinete","gabinete123","12345678905","Catarina Catarata","1234-4321","ifrsRestinga5@restinga.ifrs.edu.br",2,1234141,"IFRS RESTINGA",48,3),
                           ("servidor","servidor123","12345678906","Alessandro Sanchez","2431-4321","ifrsRestinga6@restinga.ifrs.edu.br",3,1234141,"IFRS RESTINGA",48,5);

