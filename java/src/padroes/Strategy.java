package padroes;

import java.util.Scanner;

// Interface Strategy
interface Operation {
    double execute(double num1, double num2);
}

// Implementações concretas do Strategy
class AddOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1 + num2;
    }
}

class SubtractOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1 - num2;
    }
}

class MultiplyOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1 * num2;
    }
}
class DivideOperation implements Operation {
    @Override
    public double execute(double num1, double num2) {
        // Implementar lógica de divisão sem tratamento de divisão por zero
        return num1 / num2;
    }
}

// Contexto que utiliza a estratégia
class Calculator {
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double performOperation(double num1, double num2) {
        return operation.execute(num1, num2);
    }
}

public class Strategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Operation addOperation = new AddOperation();
        Operation subtractOperation = new SubtractOperation();

        //Criar instâncias do restante das operações
        Operation multiplyOperation = new MultiplyOperation();
        Operation divideOperation = new DivideOperation();


        // Criando a calculadora
        Calculator calculator = new Calculator();

        // Obtendo os números do usuário
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        // Obtendo a operação desejada
        String operationChoice = scanner.next();

        // Configurando a operação na calculadora
        switch (operationChoice) {
            case "+":
                calculator.setOperation(addOperation);
                break;
            case "-":
                calculator.setOperation(subtractOperation);
                break;
            case "*":
                calculator.setOperation(multiplyOperation);
                break;
            case "/":
                calculator.setOperation(divideOperation); // TODO: Utilizar a nova implementação de divisão
                break;
            default:
                System.out.println("Operação inválida.");
                return;
        }

        // Realizando a operação e exibindo o resultado
        double result = calculator.performOperation(num1, num2);
        System.out.println(result);
    }
}

/*
* Descrição
Você foi designado para criar uma calculadora simples em Java, aplicando o padrão de projeto Strategy para representar as operações matemáticas.

Entrada
O programa deve solicitar ao usuário dois números e a operação desejada. As operações podem ser especificadas pelos seguintes sinais: + para soma, - para subtração, * para multiplicação e / para divisão. O usuário deve inserir o sinal correspondente à operação desejada.

Saída
A calculadora deve utilizar o padrão Strategy para realizar a operação escolhida e exibir o resultado.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
100
10
/	10.0
9
4
*	36.0
4
3
+	7.0

    }
}



TESTES
Teste #1

Teste #2

Teste #3

Teste #4

Dúvidas ?
*
* */