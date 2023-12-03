CREATE TABLE PESSOA (
 ID_Pessoa INT PRIMARY KEY AUTO_INCREMENT,
 P_Nome VARCHAR(50) NOT NULL,
 Ult_Nome VARCHAR(50),
 CPF VARCHAR(14) UNIQUE NOT NULL
);
CREATE TABLE FUNCIONARIO (
 ID_Pessoa INT PRIMARY KEY,
 Salario DOUBLE NOT NULL,
 Tempo_na_Empresa INT NOT NULL,
 FOREIGN KEY (ID_Pessoa) REFERENCES PESSOA(ID_Pessoa)
 ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE CLIENTE (
 ID_Pessoa INT PRIMARY KEY,
 Saldo DOUBLE,
 FOREIGN KEY (ID_Pessoa) REFERENCES PESSOA(ID_Pessoa)
 ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE TELEFONES_P (
 ID INT PRIMARY KEY AUTO_INCREMENT,
 ID_Pessoa INT NOT NULL,
 Telefone VARCHAR(20),
 FOREIGN KEY (ID_Pessoa) REFERENCES PESSOA(ID_Pessoa)
 ON DELETE CASCADE
);
CREATE TABLE END_PESSOA (
 ID_Pessoa INT PRIMARY KEY,
 Rua VARCHAR(50) NOT NULL,
 Numero INT NOT NULL,
 Cidade VARCHAR(50) NOT NULL,
 FOREIGN KEY (ID_Pessoa) REFERENCES PESSOA(ID_Pessoa)
 ON DELETE CASCADE
);
CREATE TABLE EDITORA (
 ID_Editora INT PRIMARY KEY AUTO_INCREMENT,
 Nome VARCHAR(50) NOT NULL,
 CNPJ VARCHAR(20) UNIQUE NOT NULL,
 Nome_Gerente VARCHAR(50)
);
CREATE TABLE TELEFONES_E (
 ID INT PRIMARY KEY AUTO_INCREMENT,
 ID_Editora INT,
 Telefone VARCHAR(20),
 FOREIGN KEY (ID_Editora) REFERENCES EDITORA(ID_Editora)
 ON DELETE CASCADE
);
CREATE TABLE END_EDITORA (
 ID_Editora INT PRIMARY KEY,
 Rua VARCHAR(50) NOT NULL,
 Numero INT NOT NULL,
 Cidade VARCHAR(50) NOT NULL,
 FOREIGN KEY (ID_Editora) REFERENCES EDITORA(ID_Editora)
 ON DELETE CASCADE
);
CREATE TABLE LIVRO (
 ID_Livro INT PRIMARY KEY AUTO_INCREMENT,
 Nome VARCHAR(100) NOT NULL,
 Autor VARCHAR(50) NOT NULL,
 Categoria VARCHAR(50),
 Quantidade INT NOT NULL,
 ISBN VARCHAR(20) NOT NULL,
 ID_Editora INT,
 FOREIGN KEY (ID_Editora) REFERENCES EDITORA(ID_Editora)
);
CREATE TABLE COMPRA (
 ID_Compra INT PRIMARY KEY AUTO_INCREMENT,
 ID_Pessoa INT NOT NULL,
 ID_Livro INT NOT NULL,
 Quantidade INT NOT NULL,
 Data_Compra DATE,
 FOREIGN KEY (ID_Pessoa) REFERENCES PESSOA(ID_Pessoa),
 FOREIGN KEY (ID_Livro) REFERENCES LIVRO(ID_Livro)
);
CREATE TABLE VENDE (
 ID_Venda INT PRIMARY KEY AUTO_INCREMENT,
 ID_Pessoa INT NOT NULL,
 ID_Livro INT NOT NULL,
 Data_Venda DATE,
 Quantidade INT NOT NULL,
 FOREIGN KEY (ID_Pessoa) REFERENCES PESSOA(ID_Pessoa),
 FOREIGN KEY (ID_Livro) REFERENCES LIVRO(ID_Livro)
);
CREATE TABLE FORNECE (
 Numero_Carregamento INT PRIMARY KEY AUTO_INCREMENT,
 ID_Editora INT,
 Quantidade INT NOT NULL,
 Nome_Livro VARCHAR(100) NOT NULL,
 ISBN VARCHAR(20) NOT NULL,
 FOREIGN KEY (ID_Editora) REFERENCES EDITORA(ID_Editora)
);

INSERT INTO PESSOA (P_Nome, Ult_Nome, CPF) VALUES
 ('Douglas', 'Freitas', '129.199.296-91'),
 ('Gabriel', 'Smith', '987.654.321-09'),
 ('Filipe', 'Johnson', '555.111.222-33'),
 ('Caio', 'Williams', '444.888.777-66'),
 ('Otavio', 'Brown', '777.333.222-11');
-- FUNCIONARIO
INSERT INTO FUNCIONARIO (ID_Pessoa, Salario, Tempo_na_Empresa) VALUES
 (1, 50000.00, 2),
 (2, 60000.00, 3),
 (3, 55000.00, 1);
-- CLIENTE
INSERT INTO CLIENTE (ID_Pessoa, Saldo) VALUES
 (4, 800.00),
 (5, 1500.00);
-- TELEFONES_P
INSERT INTO TELEFONES_P (ID_Pessoa, Telefone) VALUES
 (1, '35-99774-4578'),
 (1, '35-99562-3454'),
 (2, '35-97231-6547'),
 (3, '35-99542-2134'),
 (4, '35-96554-5648'),
 (5, '35-97357-1593'),
 (5, '35-98321-7895');
-- END_PESSOA
INSERT INTO END_PESSOA (ID_Pessoa, Rua, Numero, Cidade) VALUES
 (1, 'Rua dos Alfeneiros', 145, 'Alfenas'),
 (2, 'Rua Jose da Silva', 282, 'Varginha'),
 (3, 'Rua João da Costa', 33, 'Alfenas'),
 (4, 'Avenida Governador Valadares', 04, 'Campos Gerais'),
 (5, 'Rua João de Souza Dos Reias', 575, 'Alfenas');
-- EDITORA
INSERT INTO EDITORA (Nome, CNPJ, Nome_Gerente) VALUES
 ('Atlas', '123.456.789/0001-01', 'João Gomes da Silva'),
 ('Intrinseca', '987.654.321/0002-02', 'Juliana Martins'),
 ('Saraiva', '555.111.222/0003-03', 'Erick Jonson');
 
-- TELEFONES_E
INSERT INTO TELEFONES_E (ID_Editora, Telefone) VALUES
 (1, '31-3225-4598'),
 (2, '21-3265-4587'),
 (2, '21-3263-8877'),
 (3, '35-3698-4546');
-- END_EDITORA
INSERT INTO END_EDITORA (ID_Editora, Rua, Numero, Cidade) VALUES
 (1, 'Rua da Saudade', 10, 'São Paulo'),
 (2, 'Avenida Antonieta', 20, 'Rio de Janeiro'),
 (3, 'Rua Granja Nova', 78, 'Belo Horizonte');
-- LIVRO
INSERT INTO LIVRO (Nome, Autor, Categoria, Quantidade, ISBN, ID_Editora) VALUES
 ('A tormenta das Espadas', 'George R R Martin', 'Fantasia', 100, '9877546', 1),
 ('O Aprendiz', 'Joseph Delaney', 'Fantasia', 50, '8956235', 2),
 ('O Codigo da Vinci', 'Dan Brown', 'Misterio', 80, '4578216', 2),
 ('O mundo de Sofia', 'Jostein Gaarner', 'Romance', 80, '4588793', 3),
 ('Diario de Anne Frank', 'Anne Frank', 'Biografia', 60, '3278654', 3);
-- COMPRA
INSERT INTO COMPRA (ID_Pessoa, ID_Livro, Quantidade, Data_Compra) VALUES
 (4, 1, 2, '2023-01-15'),
 (4, 3, 1, '2023-02-20'),
 (5, 5, 3, '2023-03-25'),
 (4, 2, 2, '2023-04-10'),
 (5, 4, 1, '2023-05-05');
-- VENDE
INSERT INTO VENDE (ID_Pessoa, ID_Livro, Data_Venda, Quantidade) VALUES
 (1, 3, '2023-06-15', 1),
 (2, 1, '2023-07-20', 2),
 (3, 5, '2023-08-25', 1),
 (3, 2, '2023-09-10', 3),
 (1, 4, '2023-10-05', 2);
-- FORNECE
INSERT INTO FORNECE (ID_Editora, Quantidade, Nome_Livro, ISBN) VALUES
 (1, 40, 'As Cronicas de Narnia', '4587996'),
 (2, 15, 'João e o pé de Feijão', '2365447'),
 (3, 12, 'A branca de neve', '3266897');