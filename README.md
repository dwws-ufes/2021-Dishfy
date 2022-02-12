# Dishfy

O Dishfy visa trazer para o usuário uma facilidade de manipulação em relação a suas receitas, permitindo que novas adicionando seus ingredientes, método de implementação, etc.

## 📋 Sumário

- [Pré-requisitos](#pre-req)
- [Instalação](#gettin-started)
- [Autores](#authors)
- [Licença](#license)

## ⛏️ Pré-requisitos <a name = "pre-req"></a>

Para a aplicação utilizamos as seguintes ferramentas:

- [Jakarta EE 9](https://jakarta.ee/release/9/)
- [MySQL 8.0.27](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/news-8-0-27.html)
- [WildFly 25.0.1](https://www.wildfly.org/news/2021/11/04/WildFly2501-Released/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [PrimeFaces 11](https://www.primefaces.org/primefaces-11-0-0-rc1-released/)

## 🚀 Instalação <a name = "gettin-started"></a>

1. Clone o projeto em seu computador.
```
git clone https://github.com/dwws-ufes/2021-Dishfy.git
```
2. Faça a configuração do WildFly juntamente com o MySQL, seguindo o [tutorial do JButler](https://github.com/dwws-ufes/javahostel/tree/main/jakartaee9). E então configure as dependências do Maven, como feito [aqui](https://github.com/dwws-ufes/javahostel/tree/main/jakartaee9).
  
2.1. Troque as menções a 'javahostel' e 'oldenburg' por 'dishfy'.
  
2.2. Nessa versão do sistema, para testar, os dados de ingredientes e categorias precisam ser inseridos manualmente. Os comando estão nesse [arquivo](https://github.com/dwws-ufes/2021-Dishfy/blob/main/dados.sql).
  
    ```sh
    mysql -u <usuario> -p
    ```
    
    ```mysql
    use dishfy;
    <cole aqui os comandos e aperte 'enter' no ultimo>
    ```

3. Com o WildFly e o MySQL iniciados, acesso o diretório do `dishfy` e dê o seguinte comando:
```
mvn clean install
```

4. Com o deploy realizado, acesse `localhost:8080/dishfy` para visualizar a aplicação.


## ✒️ Autores <a name = "authors"></a>

- [Wagner Porto](https://github.com/wagnerpf)
- [Pedro Vitor](https://github.com/pedrovic7997)
- [Igor Dummer](https://github.com/IgorDummer)
- [Gabriel Ferrari](https://github.com/gabkyo)

## 🔐 Licença <a name = "license"></a>

Distribuído na Licença GNU (General Public License). Veja `License.txt` para mais informações.
