DROP DATABASE IF EXISTS locadora;
CREATE DATABASE locadora;
USE locadora;

CREATE TABLE agencia (
 id_agencia INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 razao_social VARCHAR(200) NOT NULL,
 fantasia VARCHAR(150) NOT NULL,
 cnpj VARCHAR(21) NOT NULL,
 insc_estadual VARCHAR(12) NOT NULL,
 responsavel VARCHAR(100),
 logradouro VARCHAR(50) NOT NULL,
 bairro VARCHAR(25) NOT NULL,
 numero int(11) NOT NULL,
 cep VARCHAR(9) NOT NULL,
 cidade VARCHAR(30) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 telefone VARCHAR(14),
 email VARCHAR(45),
 site VARCHAR(100),
 data_cadastro DATETIME,
 data_manutencao DATETIME,
 ativo INT
);


CREATE TABLE cliente (
 id_cliente INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50) NOT NULL,
 data_nascimento DATE NOT NULL,
 cpf VARCHAR(15) NOT NULL,
 rg VARCHAR(9),
 cnh VARCHAR(11) NOT NULL,
 validade_cnh DATE NOT NULL,
 estado_emissor VARCHAR(45) NOT NULL,
 genero CHAR(1),
 logradouro VARCHAR(50) NOT NULL,
 bairro VARCHAR(30),
 numero INT(11) NOT NULL,
 cep VARCHAR(9) NOT NULL,
 cidade VARCHAR(25) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 telefone VARCHAR(14),
 email VARCHAR(45),
 id_agencia INT(11),
 id_funcionario	 INT(11) NOT NULL,
 data_cadastro DATETIME,
 data_manutencao DATETIME,
 ativo INT,

 FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia)
);


CREATE TABLE funcionario (
 id_funcionario INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50) NOT NULL,
 data_nascimento DATE NOT NULL,
 cpf VARCHAR(15) NOT NULL,
 rg VARCHAR(9) NOT NULL,
 genero CHAR(1) NOT NULL,
 logradouro VARCHAR(50) NOT NULL,
 numero INT NOT NULL,
 bairro VARCHAR(30),
 cep VARCHAR(9) NOT NULL,
 cidade VARCHAR(25) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 telefone VARCHAR(14),
 email VARCHAR(45),
 nivel CHAR(1) NOT NULL,
 usuario VARCHAR(100),
 funcionario_supervisor INT(11),
 id_agencia INT(11),
 data_cadastro DATETIME,
 data_manutencao DATETIME,
 ativo INT NOT NULL,

 FOREIGN KEY (funcionario_supervisor) REFERENCES funcionario (id_funcionario),
 FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia)
);


CREATE TABLE pagamento (
 id_pagamento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 tipo VARCHAR(50),
 nome_titular VARCHAR(100),
 cpf VARCHAR(11),
 data_pagamento DATE
);


CREATE TABLE veiculo (
 id_veiculo INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 modelo VARCHAR(15),
 fabricante VARCHAR(20),
 imagem VARCHAR(60),
 ano INT(11),
 grupo INT(11),
 acessorio int(11),
 chassi VARCHAR(17),
 placa VARCHAR(7),
 cidade VARCHAR(150),
 uf VARCHAR(2),
 kmrodado DOUBLE,
 precokmlivre DOUBLE,
 precokmcontrolado DOUBLE,
 status INT(11),
 id_agencia INT(11),
 id_funcionario INT(11) NOT NULL,
 data_cadastro DATETIME,
 data_manutencao DATETIME,
 ativo INT,

 FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia)
);


CREATE TABLE locacao (
 id_locacao INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 data_hora_locacao DATETIME NOT NULL,
 data_hora_prevista_devolucao DATETIME NOT NULL,
 data_hora_devolucao DATETIME,
 agencia_devolucao INT(11) NOT NULL,
 tipo_tarifa INT(11) NOT NULL,
 km_locacao DOUBLE NOT NULL,
 km_devolucao INT(11) NOT NULL,
 valor DOUBLE NOT NULL,
 tipo_pagamento CHAR(60),
 valor_acrescimo DOUBLE,
 status INT,
 id_veiculo INT(11),
 id_cliente INT(11),
 id_pagamento INT NOT NULL,
 id_funcionario INT NOT NULL,
 id_agencia INT NOT NULL,

 FOREIGN KEY (id_veiculo) REFERENCES veiculo (id_veiculo),
 FOREIGN KEY (id_pagamento) REFERENCES pagamento (id_pagamento)
);

CREATE TABLE uf (
 uf VARCHAR(2) NOT NULL,
 estado VARCHAR(20) NOT NULL,
 codigo_ibge INT(10) NOT NULL
);

ALTER TABLE uf ADD CONSTRAINT PK_uf PRIMARY KEY (uf);

CREATE TABLE cidade (
 id_cidade INT(10) NOT NULL,
 cidade VARCHAR(100) NOT NULL,
 codigo_ibge INT(10) NOT NULL,
 uf VARCHAR(2)
);

ALTER TABLE cidade ADD CONSTRAINT PK_cidade PRIMARY KEY (id_cidade);


CREATE TABLE bairro (
 id_bairro INT(10) NOT NULL,
 bairro VARCHAR(50) NOT NULL,
 id_cidade INT(10) NOT NULL
);

ALTER TABLE bairro ADD CONSTRAINT PK_bairro PRIMARY KEY (id_bairro);


CREATE TABLE endereco (
 cep VARCHAR(10) NOT NULL,
 endereco VARCHAR(200) NOT NULL,
 id_cidade INT(10) NOT NULL,
 id_bairro INT(10) NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT PK_endereco PRIMARY KEY (cep);

ALTER TABLE cidade ADD CONSTRAINT FK_tend_cidade_1 FOREIGN KEY (uf) REFERENCES uf (uf);

ALTER TABLE bairro ADD CONSTRAINT FK_bairro_0 FOREIGN KEY (id_cidade) REFERENCES cidade (id_cidade);

ALTER TABLE endereco ADD CONSTRAINT FK_endereco_0 FOREIGN KEY (id_cidade) REFERENCES cidade (id_cidade);
ALTER TABLE endereco ADD CONSTRAINT FK_endereco_1 FOREIGN KEY (id_bairro) REFERENCES bairro (id_bairro);
