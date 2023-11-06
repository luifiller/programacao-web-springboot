-- Inserir autor 1
INSERT INTO escritor (nome, nacionalidade, quantidade_publicacoes, idade)
VALUES ('Miguel de Cervantes', 'Espanha', 16, 68);

-- Inserir autor 2
INSERT INTO escritor (nome, nacionalidade, quantidade_publicacoes, idade)
VALUES ('J.K. Rowling', 'Reino Unido', 15, 57);

-- Inserir autor 3
INSERT INTO escritor (nome, nacionalidade, quantidade_publicacoes, idade)
VALUES ('George Orwell', 'Reino Unido', 11, 46);

-- Inserir autor 4
INSERT INTO escritor (nome, nacionalidade, quantidade_publicacoes, idade)
VALUES ('J.R.R. Tolkien', 'Reino Unido', 30, 81);

-- Inserir autor 5
INSERT INTO escritor (nome, nacionalidade, quantidade_publicacoes, idade)
VALUES ('Gabriel García Márquez', 'Colômbia', 22, 87);

-- Inserir livro 1
INSERT INTO livro (nome, ano_publicacao, autor, editora, genero, quantidade_paginas, preco, escritor_id)
VALUES ('Dom Quixote', '1605-01-01', 'Miguel de Cervantes', 'Editorial Castalia', 'Romance de Cavalaria', 863, 45.99,
        1);

-- Inserir livro 2
INSERT INTO livro (nome, ano_publicacao, autor, editora, genero, quantidade_paginas, preco, escritor_id)
VALUES ('Harry Potter e a Pedra Filosofal', '1997-01-01', 'J.K. Rowling', 'Bloomsbury', 'Fantasia', 223, 29.99, 2);

-- Inserir livro 3
INSERT INTO livro (nome, ano_publicacao, autor, editora, genero, quantidade_paginas, preco, escritor_id)
VALUES ('1984', '1949-01-01', 'George Orwell', 'Secker and Warburg', 'Ficção Distópica', 328, 19.99, 3);

-- Inserir livro 4
INSERT INTO livro (nome, ano_publicacao, autor, editora, genero, quantidade_paginas, preco, escritor_id)
VALUES ('O Senhor dos Anéis: A Sociedade do Anel', '1954-01-01', 'J.R.R. Tolkien', 'George Allen & Unwin',
        'Fantasia Épica', 423, 34.99, 4);

-- Inserir livro 5
INSERT INTO livro (nome, ano_publicacao, autor, editora, genero, quantidade_paginas, preco, escritor_id)
VALUES ('Cem Anos de Solidão', '1967-01-01', 'Gabriel García Márquez', 'Harper & Row', 'Realismo Mágico', 417, 27.99,
        5),
       ('Cem Anos de Depressão', '1967-11-11', 'Gabriel García Márquez', 'Harper & Row', 'Realismo Mágico', 417, 27.99,
        null);