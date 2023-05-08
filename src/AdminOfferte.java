import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminOfferte extends Offertemaker {
    ArrayList<KortingOpties> gekozenKortingOpties = new ArrayList<KortingOpties>();
    double kortingOptiesPrijs;
    ArrayList<KortingOpties> kortingOpties = new ArrayList<>();

    public void offertemaken() {
        EssentieleOptiesToevoegen();
        ExtraOptiesToevoegen();
        printOfferte();
    }
    @Override
    public void ExtraOptiesToevoegen() {
        KortingOpties anker = new KortingOpties("Anker", 100.0);
        KortingOpties navigatie = new KortingOpties("Navigatie", 500.0);
        KortingOpties zwemtrap = new KortingOpties("Zwemtrap", 200.0);
        KortingOpties reddingsboei = new KortingOpties("Reddingsboei", 50.0);
        KortingOpties radio = new KortingOpties("Radio", 300.0);
        KortingOpties dieptemeter = new KortingOpties("Dieptemeter", 400.0);
        KortingOpties radar = new KortingOpties("Radar", 800.0);
        KortingOpties kompas = new KortingOpties("Kompas", 150.0);
        KortingOpties marifoon = new KortingOpties("Marifoon", 600.0);
        KortingOpties zonnedek = new KortingOpties("Zonnedek", 1000.0);
        KortingOpties ankerKorting = new KortingOpties("Anker met miliekorting", 100.0 * 0.95);
        KortingOpties navigatieKorting = new KortingOpties("Navigatie met miliekorting", 500.0 * 0.95);
        KortingOpties zwemtrapKorting = new KortingOpties("Zwemtrap met miliekorting", 200.0 * 0.95);
        KortingOpties reddingsboeiKorting = new KortingOpties("Reddingsboei met miliekorting", 50.0 * 0.95);
        KortingOpties radioKorting = new KortingOpties("Radio met miliekorting", 300.0 * 0.95);
        KortingOpties dieptemeterKorting = new KortingOpties("Dieptemeter met miliekorting", 400.0 * 0.95);
        KortingOpties radarKorting = new KortingOpties("Radar met miliekorting", 800.0 * 0.95);
        KortingOpties kompasKorting = new KortingOpties("Kompas met miliekorting", 150.0 * 0.95);
        KortingOpties marifoonKorting = new KortingOpties("Marifoon met miliekorting", 600.0 * 0.95);
        KortingOpties zonnedekKorting = new KortingOpties("Zonnedek met miliekorting", 1000.0 * 0.95);

        // voeg kortings-opties toe
        KortingOpties ankerKorting1 = new KortingOpties("Anker - 2 voor de prijs van 1", 200.0);
        KortingOpties zonnedekKorting1 = new KortingOpties("zonnedek - 2 voor de prijs van 1", 1000);
        KortingOpties navigatieKorting2 = new KortingOpties("Navigatie - 3 voor de prijs van 2", 1000.0);
        KortingOpties zwemtrapKorting50 = new KortingOpties("Zwemtrap - 50% korting", 200.0 * 0.5);
        KortingOpties radioKorting30 = new KortingOpties("Radio - 30% korting", 300.0 * 0.7);
        KortingOpties marifoonKorting30 = new KortingOpties("Marifoon - 30% korting", 600.0 * 0.7);

        kortingOpties.add(ankerKorting1);
        kortingOpties.add(zonnedekKorting1);
        kortingOpties.add(navigatieKorting2);
        kortingOpties.add(zwemtrapKorting50);
        kortingOpties.add(radioKorting30);
        kortingOpties.add(marifoonKorting30);
        kortingOpties.add(anker);
        kortingOpties.add(ankerKorting);
        kortingOpties.add(navigatie);
        kortingOpties.add(navigatieKorting);
        kortingOpties.add(zwemtrap);
        kortingOpties.add(zwemtrapKorting);
        kortingOpties.add(reddingsboei);
        kortingOpties.add(reddingsboeiKorting);
        kortingOpties.add(radio);
        kortingOpties.add(radioKorting);
        kortingOpties.add(dieptemeter);
        kortingOpties.add(dieptemeterKorting);
        kortingOpties.add(radar);
        kortingOpties.add(radarKorting);
        kortingOpties.add(kompas);
        kortingOpties.add(kompasKorting);
        kortingOpties.add(marifoon);
        kortingOpties.add(marifoonKorting);
        kortingOpties.add(zonnedek);
        kortingOpties.add(zonnedekKorting);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Kies een optie:\n");
            for (int i = 0; i < kortingOpties.size(); i++) {
                System.out.println((i + 1) + ". " + kortingOpties.get(i).getNaam() + " - " + kortingOpties.get(i).getPrijs());
            }
            System.out.println("0. Stop met kiezen");

            int keuze = input.nextInt();
            if (keuze == 0) {
                break;
            }

            if (keuze > 0 && keuze <= kortingOpties.size()) {
                Optie gekozenOpties = kortingOpties.get(keuze - 1);
                gekozenKortingOpties.add((KortingOpties)gekozenOpties);
                System.out.println("\nOptie '" + gekozenOpties.getNaam() + "' is toegevoegd.");
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
            for (Optie optie : gekozenKortingOpties) {
                kortingOptiesPrijs += optie.getPrijs();
            }
            System.out.println("\nde prijs van de extra opties: " + kortingOptiesPrijs);
        }
    }
    @Override
    public void printOfferte() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nOp welke naam mag de offerte?");
        String naam = input.nextLine();
        System.out.println("Geef je klanttype aan(bedrijf/particulier/overheid): ");
        String klantType = "";

        while (true) {
            klantType = input.nextLine();
            if (klantType.equals("bedrijf") || klantType.equals("particulier") || klantType.equals("overheid")) {
                break;
            } else {
                System.out.println("Ongeldige invoer. Kies uit bedrijf, particulier of overheid.");
            }
        }
        if (klantType.equals("bedrijf")) {
            klantTypeKorting = 0.95;
        } else if (klantType.equals("particulier")){
            klantTypeKorting = 1;
        } else if(klantType.equals("overheid")){
            klantTypeKorting = 0.90;

        }

        double totaalPrijs = beginPrijs + kortingOptiesPrijs + essentieleOptiesPrijs * klantTypeKorting;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);

        System.out.println("\nOfferte voor " + ":");
        System.out.println("- Standaardprijs: €" + beginPrijs);
        System.out.println("\n- Essentiële opties:");
        for (EssentieleOpties optie : gekozenEssentieleOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getPrijs());
        }
        System.out.println("Prijs van de essentiële opties bij elkaar: " + essentieleOptiesPrijs);
        System.out.println("\n- Extra opties:");
        for (KortingOpties optie : gekozenKortingOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getPrijs());
        }
        System.out.println("Prijs van de extra opties bij elkaar: " + kortingOptiesPrijs);
        if (klantType.equals("bedrijf")) {
            System.out.println("\nAls bedrijf krijgt u 5% korting!");
        } else if (klantType.equals("particulier")){
            System.out.println("\nAls particulier krijgt u jammer genoeg geen korting.");
        } else if(klantType.equals("overheid")){
            System.out.println("\nAls overheidsinstelling krijgt u 10% korting!");
        }
        System.out.println("\nDe totaalprijs is: " + totaalPrijs);
    }
}
