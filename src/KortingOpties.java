import java.util.ArrayList;
import java.util.Scanner;

public class AdminOfferte extends Offertemaker {
    ArrayList<ExtraOpties> gekozenKortingOpties = new ArrayList<>();
    double kortingOptiesPrijs;

//    public AdminOfferte(String naam, double prijs) {
//        super(naam, prijs);
//    }
    ArrayList<AdminOfferte> kortingOpties = new ArrayList<>();
    public void ExtraOptiesMetAdminKortingToevoegen() {
        AdminOfferte anker = new AdminOfferte("Anker", 100.0);
        AdminOfferte navigatie = new AdminOfferte("Navigatie", 500.0);
        AdminOfferte zwemtrap = new AdminOfferte("Zwemtrap", 200.0);
        AdminOfferte reddingsboei = new AdminOfferte("Reddingsboei", 50.0);
        AdminOfferte radio = new AdminOfferte("Radio", 300.0);
        AdminOfferte dieptemeter = new AdminOfferte("Dieptemeter", 400.0);
        AdminOfferte radar = new AdminOfferte("Radar", 800.0);
        AdminOfferte kompas = new AdminOfferte("Kompas", 150.0);
        AdminOfferte marifoon = new AdminOfferte("Marifoon", 600.0);
        AdminOfferte zonnedek = new AdminOfferte("Zonnedek", 1000.0);
        AdminOfferte ankerKorting = new AdminOfferte("Anker met miliekorting", 100.0 * 0.95);
        AdminOfferte navigatieKorting = new AdminOfferte("Navigatie met miliekorting", 500.0 * 0.95);
        AdminOfferte zwemtrapKorting = new AdminOfferte("Zwemtrap met miliekorting", 200.0 * 0.95);
        AdminOfferte reddingsboeiKorting = new AdminOfferte("Reddingsboei met miliekorting", 50.0 * 0.95);
        AdminOfferte radioKorting = new AdminOfferte("Radio met miliekorting", 300.0 * 0.95);
        AdminOfferte dieptemeterKorting = new AdminOfferte("Dieptemeter met miliekorting", 400.0 * 0.95);
        AdminOfferte radarKorting = new AdminOfferte("Radar met miliekorting", 800.0 * 0.95);
        AdminOfferte kompasKorting = new AdminOfferte("Kompas met miliekorting", 150.0 * 0.95);
        AdminOfferte marifoonKorting = new AdminOfferte("Marifoon met miliekorting", 600.0 * 0.95);
        AdminOfferte zonnedekKorting = new AdminOfferte("Zonnedek met miliekorting", 1000.0 * 0.95);

        // voeg kortings-opties toe
        AdminOfferte ankerKorting1 = new AdminOfferte("Anker - 2 voor de prijs van 1", 200.0);
        AdminOfferte zonnedekKorting1 = new AdminOfferte("zonnedek - 2 voor de prijs van 1", 1000);
        AdminOfferte navigatieKorting2 = new AdminOfferte("Navigatie - 3 voor de prijs van 2", 1000.0);
        AdminOfferte zwemtrapKorting50 = new AdminOfferte("Zwemtrap - 50% korting", 200.0 * 0.5);
        AdminOfferte radioKorting30 = new AdminOfferte("Radio - 30% korting", 300.0 * 0.7);
        AdminOfferte marifoonKorting30 = new AdminOfferte("Marifoon - 30% korting", 600.0 * 0.7);


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
                System.out.println((i + 1) + ". " + kortingOpties   .get(i).getNaam() + " - " + kortingOpties.get(i).getPrijs());
            }
            System.out.println("0. Stop met kiezen");

            int keuze = input.nextInt();
            if (keuze == 0) {
                break;
            }

            if (keuze > 0 && keuze <= kortingOpties.size()) {
                Optie gekozenOptie = kortingOpties.get(keuze - 1);
                gekozenKortingOpties.add((AdminOfferte) gekozenOptie);
                System.out.println("\nOptie '" + gekozenOptie.getNaam() + "' is toegevoegd.");
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
            for (Optie optie : gekozenKortingOpties) {
                kortingOptiesPrijs += optie.getPrijs();
            }
            System.out.println("\nde prijs van de extra opties: " + kortingOptiesPrijs);
        }
    }
}
