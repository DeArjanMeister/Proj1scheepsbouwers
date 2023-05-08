import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loginsysteem {
    private static final String FILENAME = "users.json";
    private static final Gson gson = new Gson();

    private static List<Klant> users = new ArrayList<>();

    public static List<Klant> getUsers() {
        return users;
    }


    public static void loginstart() {
        loadKlanten();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom bij onze offertemaker!\n");
        boolean done = false;
        while (!done) {
            System.out.println("Kies een optie:");
            System.out.println("1. Registreren");
            System.out.println("2. Log in");
            System.out.println("3. Admin");
            System.out.println("3. Exit\n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registreerKlant(scanner);
                    break;
                case 2:
                    login(scanner);
                    done = true;
                    break;
                case 3:
                    admin(scanner);
                    done = true;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        saveKlanten();
        System.out.println("\nGoodbye!");
    }


    public static void loadKlanten() {
        try (FileReader reader = new FileReader(FILENAME)) {
            users = gson.fromJson(reader, new TypeToken<List<Klant>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("Failed to load users: " + e.getMessage());
        }
    }

    public static void saveKlanten() {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println("Failed to save users: " + e.getMessage());
        }
    }
    public static void admin(Scanner scanner){

        String adminUsername = "admin";
        String adminPassword = "admin";
        // prompt user for username and password
        System.out.print("Geef gebruikersnaam: ");
        String username = scanner.nextLine();
        System.out.print("Enter wachtwoord: ");
        String password = scanner.nextLine();

        // check if entered username and password match admin credentials
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Login successvol.");
            AdminOfferte offerte = new AdminOfferte();
            offerte.offertemaken();
        } else {
            System.out.println("Niet goed, probeer opnieuw!");
        }
    }
    public static void registreerKlant(Scanner scanner) {
        System.out.println("Geef een gebruikersnaam:");
        String username = scanner.nextLine();

        // Check if the username already exists
        for (Klant user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Gebruikersnaam bestaat al. Geef een ander.");
                return;
            }
        }

        System.out.println("Geef een sterk wachtwoord:");
        String password = scanner.nextLine();

        users.add(new Klant(username, password));
        System.out.println("Registratie succesvol");
    }

    public static void login(Scanner scanner) {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Geef je gebruikersnaam:");
            String username = scanner.nextLine();

            System.out.println("Geef je wachtwoord:");
            String password = scanner.nextLine();

            for (Klant user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Login successvol!");
                    loggedIn = true;
                    break;
                }
            }
            if (!loggedIn) {
                System.out.println("Niet goed, probeer opnieuw!");
            }
        }
    }
}


