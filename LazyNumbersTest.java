package LazyEvaluationAndCache;

import java.util.Scanner;

public class LazyNumbersTest {

    private static void switchComands() {
        System.out.println("\nComenzile dispoinibile sunt:"
                + "\n\t- 1. Aflati daca numarul este prim."
                + "\n\t- 2. Aflati daca numarul este perfect."
                + "\n\t- 3. Aflati daca numarul este magic."
                + "\n\t- 4. Introduceti un alt numar."
                + "\n\t- 5. Iesiti din aplicatie.\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntrodu te rog un numar:");
        LazyNumbersDetails lazyNumber = new LazyNumbersDetails(sc.nextInt());

        int readNumber = lazyNumber.getNumber();
        boolean stopCommand = false;

        if(readNumber < 0) {
            System.out.println("\nIntroduceti va rog un numar pozitiv!");
            readNumber = sc.nextInt();
            lazyNumber.updateNumber(readNumber);
        }

        switchComands();

        while (!stopCommand) {
            System.out.println("Va rog alegeti urmatoarea comanda\n");
            int number = sc.nextInt();

            System.out.println();

            switch (number) {
                case 1:
                    System.out.println("Numarul introdus "
                                       + (lazyNumber.isPrime(readNumber) ? "este prim!" : "nu este prim!"));
                    break;
                case 2:
                    System.out.println("Numarul introdus "
                                       + (lazyNumber.isPerfect(readNumber) ? "este perfect!" : "nu este perfect!"));
                    break;
                case 3:
                    System.out.println("Numarul introdus " + (lazyNumber.isMagic(readNumber)
                                       ? "este magic!" : "nu este magic."));
                    break;
                case 4:
                    System.out.println("Introduceti noul numar:");
                    readNumber = sc.nextInt();
                    lazyNumber.updateNumber(readNumber);
                    System.out.println("Numarul a fost actualizat. Noul numar este " + lazyNumber.getNumber() + "\n");
                    break;
                case 5:
                    stopCommand = true;
                    break;
                default:
                    System.out.println("Comanda nu este disponibila!");
                    switchComands();
                    break;
            }
        }
        System.out.println("Va multumesc! \nLa revedere!");
    }
}
