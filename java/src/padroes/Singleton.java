package padroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    static User instancia = new User(0, null);

    private User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User getUser(int id, String name) {
        return new User(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Singleton {
    private static final List<User> users = new ArrayList<>();

    //Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários
    static User user = User.instancia;

    public static void addUser(String name) {
        //Implementar a lógica de adicionar um novo usuário na lista mutável $users.
        int id = users.size() + 1; // gerando um novo ID
        users.add(user.getUser(id, name));
    }

    public static void listUsers() {

        //Implementar a impressão dos $users, seguindo o padrão definido no enunciado.
        users.forEach(user -> System.out.println(String.format("%d - %s", user.getId(), user.getName())));

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            addUser(name);
        }

        listUsers();
    }
}

/*
Descrição
O Singleton é uma abordagem de design de software que visa assegurar a existência de apenas uma instância de uma classe e fornecer um ponto centralizado para acessá-la. Isso é especialmente benéfico em contextos nos quais é desejável manter uma única ocorrência de uma classe responsável pelo controle de um recurso compartilhado, como configurações, conexões de banco de dados ou caches.

Neste desafio, você deve criar um sistema de gerenciamento de usuários que permita adicionar e listar usuários. Você tem a opção de implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários em toda a aplicação. No entanto, a implementação do padrão Singleton é opcional e você pode optar por seguir uma abordagem diferente para resolver o desafio, se preferir.

Especificações do Desafio:

Crie uma classe User com os seguintes atributos: id (inteiro) e name (string).
Implemente uma classe UserManager que siga o padrão Singleton. Esta classe deve possuir as seguintes funcionalidades:
a. Adicionar um novo usuário ao sistema, recebendo o nome como entrada.
b. Listar todos os usuários cadastrados.
No programa principal (main), siga as etapas abaixo:
a. Solicite ao usuário a quantidade de usuários que deseja cadastrar.
b. Peça ao usuário para informar os nomes dos usuários, um por linha.
c. Após receber os nomes e cadastrar os usuários, liste os usuários cadastrados.
Entrada
Um número inteiro representando a quantidade de usuários que o usuário deseja cadastrar.

Para cada usuário a ser cadastrado, uma string contendo o nome do usuário.

Saída
Uma lista com os nomes dos usuários cadastrados.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
2
Ada
Linus	1 - Ada
2 - Linus
3
Grace
Alan
Steve
1 - Grace
2 - Alan
3 - Steve

4
Tim
Margaret
John
Richard	1 - Tim
2 - Margaret
3 - John
4 - Richard
Nota:
A implementação do padrão Singleton traz uma abordagem centralizada, com uma única instância do gerenciador de entidades, favorecendo a consistência dos dados e facilitando o acesso global. Por outro lado, optar por não usar o padrão permite maior flexibilidade, possibilitando várias instâncias independentes. A escolha depende das demandas do projeto, design e manutenção. Isso garante adaptabilidade entre diferentes linguagens ou contextos.

Caso queira saber mais sobre o Design Pattern Singleton:
https://refactoring.guru/pt-br/design-patterns/singleton


*/
