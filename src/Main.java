import service.CalcService;
import service.impl.CalcServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalcService service = new CalcServiceImpl();
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);

        LOOP:
        while (true){
            try {
                System.out.print("Enter number one: ");
                int numberOne = scanner.nextInt();
                System.out.print("Enter number two: ");
                int numberTwo = scanner.nextInt();
                System.out.print("Enter action(+/-: ");
                String action = scanForStr.nextLine();
                switch (action){
                    case "+" -> System.out.println("Result: "+ service.toFold(numberOne, numberTwo));
                    case  "-" -> System.out.println("Result: "+ service.subtraction(numberOne, numberTwo));
                }
            } catch (InputMismatchException e){
                System.out.println("Enter valid integer");
                scanner.next();
            }
        }
    }
}