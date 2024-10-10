package ui;

import model.Snack;
import service.SnackService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnackMachine {
    private List<Snack> cart = new ArrayList<>();

    public static void main(String[] args) {
        try {
            new SnackMachine().run();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private void run() throws IOException {
        boolean exit = false;
        Scanner console = new Scanner(System.in);
        SnackService snackService = new SnackService();

        System.out.println("*** Snack Machine ***");
        snackService.getSnacks().forEach(System.out::println);

        while (!exit) {
            try {
                int option = showMenu(console);
                exit = executeOptions(option, console, snackService);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private int showMenu(Scanner console) {
        System.out.print("""
                Menu:
                1. Buy snack
                2. Show ticket
                3. Add new snack
                4. Exit
                Choose an option:\s""");
        return Integer.parseInt(console.nextLine());
    }

    private boolean executeOptions(int option, Scanner console, SnackService snackService) throws IOException {
        boolean exit = switch (option) {
            case 1 -> {
                buySnack(console, snackService);
                yield false;
            }
            case 2 -> {
                showTicket(snackService);
                yield false;
            }
            case 3 -> {
                addSnack(console, snackService);
                yield false;
            }
            case 4 -> {
                System.out.println("Come back soon!");
                yield true;
            }
            default -> {
                System.out.println("Invalid option: " + option);
                yield false;
            }
        };
        return exit;
    }

    private void buySnack(Scanner console, SnackService snackService) {
        System.out.println("Which snack do you want to buy (id)?");
        int idSnack = Integer.parseInt(console.nextLine());

        snackService.getSnackById(idSnack).ifPresentOrElse(snack -> {
            cart.add(snack);
            System.out.println("Ok, snack added: " + snack);
        }, () -> System.out.println("Snack ID not found: " + idSnack));
    }

    private void showTicket(SnackService snackService) {
        if (cart.isEmpty()) {
            System.out.println("No snacks bought yet.");
            return;
        }

        System.out.println("*** Sales Ticket ***");
        double total = 0.0;
        for (Snack snack : cart) {
            System.out.println(snack);
            total += snack.getPrice();
        }
        System.out.println("Total: $" + total);
    }


    private void addSnack(Scanner console, SnackService snackService) throws IOException {
        System.out.print("Name of snack: ");
        var name = console.nextLine();
        System.out.print("Price of snack: ");
        var price = Double.parseDouble(console.nextLine());
        snackService.addSnack(new Snack(name, price));
        System.out.println("Your snack has been successfully added");
    }
}
