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

    public void loginstart()

    {
        loadKlanten();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Login System!");
        boolean done = false;
        while (!done) {
            System.out.println("Please select an option:");
            System.out.println("1. Register a new user");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registreerKlant(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        saveUsers();
        System.out.println("Goodbye!");
    }


    private static void loadKlanten() {
        try (FileReader reader = new FileReader(FILENAME)) {
            users = gson.fromJson(reader, new TypeToken<List<Klant>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("Failed to load users: " + e.getMessage());
        }
    }

    private static void saveUsers() {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println("Failed to save users: " + e.getMessage());
        }
    }

    private static void registreerKlant(Scanner scanner) {
        System.out.println("Please enter a username:");
        String username = scanner.nextLine();

        // Check if the username already exists
        for (Klant user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose another one.");
                return;
            }
        }

        System.out.println("Please enter a password:");
        String password = scanner.nextLine();

        System.out.println("Geef je klanttype aan(bedrijf/particulier/overheid: ");
        String klantType = "";

        while (true) {
            klantType = scanner.nextLine();
            if (klantType.equals("bedrijf") || klantType.equals("particulier") || klantType.equals("overheid")) {
                break;
            } else {
                System.out.println("Ongeldige invoer. Kies uit bedrijf, particulier of overheid.");
            }
        }

        users.add(new Klant(username, password, klantType));
        System.out.println("User registered successfully!");
    }

    private static void login(Scanner scanner) {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        for (Klant user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
    }
}


