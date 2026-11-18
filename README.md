# Nomes
Gabriel Ferreira Silva & Matheus Salgado Caldeira

# Controle de Estoque

Sistema inicial de cadastro e consulta de produtos com Java, Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA e H2.

## Requisitos
- Java 17 ou superior (este projeto está configurado para Java 17)
- Maven 3.6.3 ou superior
- IntelliJ IDEA

## Como abrir no IntelliJ
1. Extraia o arquivo ZIP.
2. No IntelliJ, escolha **File > Open** e selecione a pasta `controle-estoque` (a pasta que contém `pom.xml`).
3. Aguarde o IntelliJ importar as dependências Maven.
4. Abra `EstoqueApplication.java` e execute o método `main`.
5. Acesse `http://localhost:8080` no navegador.

## Telas
- `/cadastro`: cadastra produto, preço unitário e quantidade.
- `/estoque`: lista os produtos e calcula o valor total de cada linha.

## Banco H2
O banco está configurado em arquivo na pasta `data`, para preservar os produtos entre reinicializações. O console do H2 fica em `http://localhost:8080/h2-console`.

Dados do console:
- JDBC URL: `jdbc:h2:file:./data/estoquedb`
- User Name: `sa`
- Password: (deixe vazio)

## Observação
O valor total é calculado no Java por `preco × quantidade`; ele não é armazenado como uma coluna separada no banco.
# controle_estoque
