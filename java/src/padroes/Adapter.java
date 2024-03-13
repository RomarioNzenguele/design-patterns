package padroes;


import java.util.Scanner;

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    public double convertUSDtoGBP(double amount) {
        return amount * 0.80; // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
    private final OldCurrencyConverter oldConverter;
    // Taxa de conversão de GBP para EUR
    private final double gbpToEurRate = 1.0625;

    public CurrencyAdapter(OldCurrencyConverter oldConverter) {
        this.oldConverter = oldConverter;
    }

    // TODO: Implementar método de conversão de USD para outra moeda (por exemplo, JPY)
    double convertUSDtoEUR(double amount) {
        // Converter USD para GBP usando o conversor antigo
        double amountInGBP = oldConverter.convertUSDtoGBP(amount);
        // Converter GBP para EUR aplicando a taxa de conversão adicional
        return amountInGBP * gbpToEurRate;
    }
    // Dica: Você pode criar métodos adicionais conforme necessário.

}

public class Adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        OldCurrencyConverter oldConverter = new OldCurrencyConverter();
        CurrencyAdapter adapter = new CurrencyAdapter(oldConverter);

        // Chamar o método para converter USD para a nova moeda desejada (por exemplo, JPY)
        double amountInEUR = adapter.convertUSDtoEUR(input);

        // Imprimir o resultado da conversão
        System.out.println("USD: " + input);

        // Imprimir o resultado da conversão com a nova moeda (por exemplo, JPY)
        System.out.println("EUR: " + amountInEUR);

    }
}