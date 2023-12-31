import MyExceptions.Notfoud;
import dao.impl.UserDaoImpl;
import db.DataBase;
import models.User;
import service.CalcService;
import service.impl.CalcServiceImpl;
import service.impl.UserServiceImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("My names Nurlan");
        CalcService service = new CalcServiceImpl();


        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        System.out.println("Nurislam");
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        UserDaoImpl userDao = new UserDaoImpl(dataBase);
        UserServiceImpl userService = new UserServiceImpl(userDao);
        LOOPONE:
        while (true) {
            System.out.println("""
                    Choose app :
                    Menu
                    1.Super Calculator
                    2.Instagram
                    0.Exit
                    """);
            try {
<<<<<<< HEAD
                System.out.println("\n");




                System.out.print("Enter number one: ");
                int numberOne = scanner.nextInt();
                System.out.print("Enter number two: ");
                int numberTwo = scanner.nextInt();
                System.out.print("Enter action(    {+} || {-} || {/} || {*}  ) ");
                String action = scanForStr.nextLine();
                switch (action){
                    case "+" -> System.out.println("Result: "+ service.toFold(numberOne, numberTwo));
                    case  "-" -> System.out.println("Result: "+ service.subtraction(numberOne, numberTwo));
                    case  "/" -> System.out.println("Result: " + service.device(numberOne,numberTwo));
                    case  "*" -> System.out.println("Result: " + service.add(numberOne,numberTwo));
                    default -> System.out.println("Incorrect choice");
=======
                int actionmain = new Scanner(System.in).nextInt();
                switch (actionmain) {
                    case 1 -> {
                        LOOP:
                        while (true) {
                            try {
                                System.out.println("\n");
                                System.out.print("Enter number one: ");
                                int numberOne = scanner.nextInt();
                                System.out.print("Enter number two: ");
                                int numberTwo = scanner.nextInt();
                                System.out.print("Enter action(    {+} || {-} || {/} || {*}  ) ");
                                String action = scanForStr.nextLine();
                                switch (action) {
                                    case "+" -> System.out.println("Result: " + service.toFold(numberOne, numberTwo));
                                    case "-" ->
                                            System.out.println("Result: " + service.subtraction(numberOne, numberTwo));
                                    case "/" -> System.out.println("Result: " + service.device(numberOne, numberTwo));
                                    case "*" -> System.out.println("Result: " + service.add(numberOne, numberTwo));
                                    default -> System.out.println("Incorrect choice");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter valid integer");
                                scanner.next();
                            }
                        }
                    }
                    case 2 -> {
                        LOOP2:
                        while (true) {
                            User currentUser = null;
                            System.out.println("""
                                    Choose command
                                    1.Registrasia
                                    2.Login
                                    0.Exit
                                      """);
                            try {
                                int action = new Scanner(System.in).nextInt();
                                switch (action) {
                                    case 1 -> System.out.println(userService.registratsia(new User()));
                                    case 2 -> {
                                        currentUser = userService.login(new User());
                                        System.out.println("Welcome " + currentUser.getLogin());
                                        LOOP3:
                                        while (true) {
                                            System.out.println("""
                                                    Choose command:
                                                    1.Add post
                                                    2.Find post
                                                    3.Find user by email
                                                    0.Exit
                                                    """);
                                            try {
                                                int command = new Scanner(System.in).nextInt();
                                                switch (command) {
                                                    case 1 -> {
                                                        userService.addnewPost(currentUser);
                                                    }
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
                                                            System.out.println(userService.findUserByEmail(new Scanner(System.in).nextLine()));
                                                        } catch (Notfoud e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                    case 0 -> {
                                                        break LOOP3;
                                                    }
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("Write number");
                                            }
                                        }

                                    }
                                    case 0 -> {
                                        break LOOP2;
                                    }
                                }
                            } catch (InputMismatchException exception) {
                                System.out.println("Write number");
                            }
                        }

                    }
                    case 0 -> {
                        break LOOPONE;
                    }
>>>>>>> 02f9ca6f43791272ee30d25bfd8e8f74be2477c3
                }
            } catch (InputMismatchException e) {
                System.out.println("Write number");
            }
        }
    }
}