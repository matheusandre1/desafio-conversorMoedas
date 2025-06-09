
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Exchange exchange = null;
        var opcao = 0;
        System.out.println("Seja Bem vindo ao conversor de Moeda");

        while (opcao != 7) {
            exchange = new Exchange("", "");

            exchange.Menu();
            opcao = scanner.nextInt();

            System.out.println("Digite o valor que deseja converter");
            double valor = scanner.nextDouble();

           switch (opcao) {
               case 1: exchange = new Exchange("USD", "ARS", 0); break;
               case 2: exchange = new Exchange("ARS", "USD", 0); break;
               case 3: exchange = new Exchange("USD", "BRL", 0); break;
               case 4: exchange = new Exchange("BRL", "USD", 0); break;
               case 5: exchange = new Exchange("USD", "COP", 0); break;
               case 6: exchange = new Exchange("COP", "USD", 0); break;
          }

            double result = exchange.ConversaoMoeda(valor);

            System.out.printf("Valor %.2f [%s] corresponde ao valor final de  >>>  %.2f  [%s]", valor, exchange.getBaseCode(),result, exchange.getTargetCode());
            System.out.println();
        }
    }





}