package padroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface Observer
interface IObserver {
    void update(String productName);
}

// Classe concreta Observer
class User_ implements IObserver {
    private String name;

    public User_(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("Notificacao recebida: Novo produto adicionado - " + productName);
    }
}

// Interface Observable
interface CatalogObservable {
    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers(String productName);
}

// Classe concreta Observable
class Catalog implements CatalogObservable {
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers(String productName) {
        // TODO: Implementar lógica para notificar apenas os usuários que desejam ser notificados
        observers.forEach(observer -> observer.update(productName));
    }

    public void addProduct(String name, String description, double price) {
        notifyObservers(name);
    }
}

public class Observer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando catálogo e usuário
        Catalog catalog = new Catalog();
        User_ user = new User_("Usuário 1");

        // Inscricao do usuário no catálogo
        catalog.addObserver(user);

        // Adicionando novo produto
        String name = scanner.nextLine();
        String description = scanner.nextLine();
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consumir a quebra de linha após nextDouble
        String subscribeChoice = scanner.nextLine();

        // TODO: Verifique qual foi a escolha de notificação (S ou N) do usuário
        if (subscribeChoice.equalsIgnoreCase("S")) {
            // Adicionando produto ao catálogo
            catalog.addProduct(name, description, price);
        } else if (subscribeChoice.equalsIgnoreCase("N")) {
            System.out.println("Programa Encerrado.");
        }

    }
}

/*
Descrição
Você deve aprimorar o sistema de monitoramento de produtos, adicionando a capacidade de exibir uma mensagem específica para cada usuário quando um novo produto é adicionado ao catálogo. Além disso, implemente a funcionalidade de permitir que os usuários cancelem sua assinatura para deixar de receber notificações sobre novos produtos.

Entrada
O programa deve solicitar ao usuário que insira o nome do usuário para realizar a ação desejada.
Se o usuário deseja cancelar a assinatura, ele deve digitar "cancelar". Se desejar receber notificações, deve digitar qualquer outro valor.
Se o usuário optar por adicionar um novo produto, será solicitado o nome do produto a ser adicionado.
Saída
Após cada ação, o programa deve exibir mensagens informativas para indicar se a assinatura foi cancelada com sucesso, se o usuário ainda está assinando notificações ou se o produto foi adicionado ao catálogo.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
TV
Smart
999
S	Notificacao recebida: Novo produto adicionado - TV
Smartphone
Apple
3000
S	Notificacao recebida: Novo produto adicionado - Smartphone
Mouse
Sem fio
340
N	Programa Encerrado.
 */