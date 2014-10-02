DROP DATABASE IF EXISTS locadora;
CREATE DATABASE locadora;
USE locadora;

CREATE TABLE agencia (
 id_agencia INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 razao_social VARCHAR(200) NOT NULL,
 fantasia VARCHAR(150) NOT NULL,
 cnpj VARCHAR(21) NOT NULL,
 insc_estadual VARCHAR(45) NOT NULL,
 logradouro VARCHAR(50) NOT NULL,
 bairro VARCHAR(25) NOT NULL,
 numero VARCHAR(7) NOT NULL,
 cep VARCHAR(9) NOT NULL,
 cidade VARCHAR(30) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 telefone VARCHAR(11),
 email VARCHAR(45),
 site VARCHAR(100)
);


CREATE TABLE cliente (
 id_cliente INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50) NOT NULL,
 data_nascimento DATE NOT NULL,
 cpf VARCHAR(11) NOT NULL,
 rg VARCHAR(9),
 cnh VARCHAR(11) NOT NULL,
 validade_cnh DATE NOT NULL,
 estado_emissor VARCHAR(45) NOT NULL,
 genero INT,
 logradouro VARCHAR(50) NOT NULL,
 bairro VARCHAR(30),
 numero VARCHAR(7) NOT NULL,
 cep VARCHAR(8) NOT NULL,
 cidade VARCHAR(25) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 telefone VARCHAR(11),
 email VARCHAR(45),
 id_agencia INT(11),

 FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia)
);


CREATE TABLE funcionario (
 id_funcionario INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(50) NOT NULL,
 data_nascimento DATE NOT NULL,
 cpf VARCHAR(11) NOT NULL,
 rg VARCHAR(9) NOT NULL,
 genero CHAR(1) NOT NULL,
 logradouro VARCHAR(50) NOT NULL,
 numero VARCHAR(7) NOT NULL,
 bairro VARCHAR(30),
 cep VARCHAR(8) NOT NULL,
 cidade VARCHAR(25) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 telefone VARCHAR(11),
 email VARCHAR(45),
 nivel CHAR(1) NOT NULL,
 usuario VARCHAR(100),
 data_cadastro DATETIME,
 data_manutencao DATETIME,
 funcionario_supervisor INT(11),
 id_agencia INT(11),

 FOREIGN KEY (funcionario_supervisor) REFERENCES funcionario (id_funcionario),
 FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia),

 CONSTRAINT USUARIO_UNIQUE UNIQUE(usuario)
);


CREATE TABLE pagamento (
 id_pagamento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 tipo VARCHAR(30),
 nome VARCHAR(60),
 cpf VARCHAR(11),
 data_pagamento DATE
);


CREATE TABLE veiculo (
 id_veiculo INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 modelo VARCHAR(15),
 fabricante VARCHAR(20),
 imagem VARCHAR(60),
 ano YEAR(4),
 grupo INT(11),
 acessorio VARCHAR(350),
 chassi VARCHAR(17),
 placa VARCHAR(7),
 cidade VARCHAR(25),
 uf VARCHAR(2),
 kmrodado FLOAT,
 precokmlivre FLOAT,
 precokmcontrolado FLOAT,
 status_veiculo VARCHAR(45),
 id_agencia INT(11),

 FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia)
);


CREATE TABLE locacao (
 id_locacao INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 data_hora_locacao DATETIME NOT NULL,
 data_hora_prevista_devolucao DATETIME NOT NULL,
 agencia_devolucao INT(11) NOT NULL,
 tipo_tarifa INT(11) NOT NULL,
 km_locacao FLOAT NOT NULL,
 km_devolucao INT(11) NOT NULL,
 valor FLOAT NOT NULL,
 tipo_pagamento CHAR(10),
 valor_acrescimo FLOAT,
 id_veiculo INT(11),
 id_pagamento INT,

 FOREIGN KEY (id_veiculo) REFERENCES veiculo (id_veiculo),
 FOREIGN KEY (id_pagamento) REFERENCES pagamento (id_pagamento)
);


CREATE TABLE cliente_locacao (
 id_cliente_locacao INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 data_hora_locacao DATETIME NOT NULL,
 data_hora_devolucao DATETIME,
 id_cliente INT(11),
 id_locacao INT(11),

 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
 FOREIGN KEY (id_locacao) REFERENCES locacao (id_locacao)
);

