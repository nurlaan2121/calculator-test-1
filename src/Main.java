import dao.impl.UserDaoImpl;
import db.DataBase;
import models.User;
import service.CalcService;
import MyExceptions.Notfoud;
import service.impl.CalcServiceImpl;
import service.impl.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalcService service = new CalcServiceImpl();
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        UserServiceImpl userService = new UserServiceImpl(new UserDaoImpl(dataBase));
        OuterLoop:
        while (true) {
            System.out.println("""
                    Choose app :
                    0.Exit
                    1.Super Calculator
                    2.Instagram
                    """);
            try {
                int actionmain = new Scanner(System.in).nextInt();
                switch (actionmain) {
                    case 0 -> {break OuterLoop;}
                    case 1 -> {
                        LOOP:
                        while (true) {
                            try {
                                System.out.println("\n");
                                System.out.print("Enter number one: ");
                                int numberOne = scanner.nextInt();
                                System.out.print("Enter number two: ");
                                int numberTwo = scanner.nextInt();
                                System.out.print("Enter action( {+} || {-} || {/} || {*} / (0 for exit) ): ");
                                String action = scanForStr.nextLine();
                                switch (action) {
                                    case "+" -> System.out.println("Result: " + service.toFold(numberOne, numberTwo));
                                    case "-" ->
                                            System.out.println("Result: " + service.subtraction(numberOne, numberTwo));
                                    case "/" -> System.out.println("Result: " + service.device(numberOne, numberTwo));
                                    case "*" -> System.out.println("Result: " + service.add(numberOne, numberTwo));
                                    case "0" -> {
                                        break LOOP;
                                    }
                                    default -> System.out.println("Incorrect choice");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter valid integer");
                                scanner.next();
                            }
                        }
                    }
                    case 2 -> {
                        User currentUser = null;
                        InnerLoop:
                        while (true) {
                            System.out.println("""
                                    Choose command
                                    0.Exit
                                    1.Registrasia
                                    2.Login
                                    0.Exit
                                                                  
                                      """);
                            try {
                                int action = new Scanner(System.in).nextInt();
                                switch (action) {
                                    case 0 -> {break InnerLoop;}
                                    case 1 -> System.out.println(userService.registratsia(new User()));
                                    case 2 -> {
                                       loopInner:
                                        while (true){
                                            currentUser = userService.login(new User());
                                            System.out.println("Welcome " + currentUser.getLogin());
                                            System.out.println("""
                                                Choose command:
                                                0.Exit
                                                1.Add post
                                                2.Find post
                                                3.Find user by email
                                                                                            
                                                """);
                                            try {
                                                int command = new Scanner(System.in).nextInt();
                                                switch (command) {
                                                    case 0 -> {break loopInner;}
                                                    case 1 -> userService.addnewPost(currentUser);
                                                    case 2 -> {
                                                        System.out.println("Write post usera");
                                                        try {
                                                            System.out.println(userService.findUserByPost(new Scanner(System.in).nextLine()));
                                                        } catch (Notfoud e) {
                                                            System.out.println(e.getMessage());

                                                        }
                                                    }
                                                    case 3 -> {
                                                        System.out.println("Write email: ");
                                                        try {
                                                            userService.findUserByEmail(new Scanner(System.in).nextLine());
                                                        } catch (Notfoud e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("Write number");
                                            }
                                        }
                                    }
                                }
                            } catch (InputMismatchException exception) {
                                System.out.println("Write number");

                            }
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Write number");
            }
        }
    }
}