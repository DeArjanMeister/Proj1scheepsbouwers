import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Offertemaker {
    int beginPrijs;
    double klantTypeKorting;

    double essentieleOptiesPrijs;

    double extraOptiesPrijs;

    ArrayList<ExtraOpties> gekozenExtraOpties = new ArrayList<>();
    ArrayList<EssentieleOpties> essentieleOpties = new ArrayList<>();
    ArrayList<EssentieleOpties> randomKorting = new ArrayList<>();
    ArrayList<ExtraOpties> extraOpties = new ArrayList<>();
    ArrayList<EssentieleOpties> gekozenEssentieleOpties = new ArrayList<>();

    public void offertemaken() {
        EssentieleOptiesToevoegen();
        ExtraOptiesToevoegen();
        printOfferte();
    }

    public void EssentieleOptiesToevoegen() {
        EssentieleOpties romp = new EssentieleOpties("Romp", 2000.0);
        EssentieleOpties zeilen = new EssentieleOpties("Zeilen", 3000.0);
        EssentieleOpties roer = new EssentieleOpties("Roer", 1000.0);
        EssentieleOpties mast = new EssentieleOpties("Mast", 1500.0);
        EssentieleOpties zwaard = new EssentieleOpties("Zwaard", 1200.0);
        EssentieleOpties stuur = new EssentieleOpties("Stuur", 500.0);
        EssentieleOpties rompKorting = new EssentieleOpties("Romp met miliekorting", 2000.0 * 0.95);
        EssentieleOpties zeilenKorting = new EssentieleOpties("Zeilen met miliekorting", 3000.0 * 0.95);
        EssentieleOpties roerKorting = new EssentieleOpties("Roer met miliekorting", 1000.0 * 0.95);
        EssentieleOpties mastKorting = new EssentieleOpties("Mast met miliekorting", 1500.0 * 0.95);
        EssentieleOpties zwaardKorting = new EssentieleOpties("Zwaard met miliekorting", 1200.0 * 0.95);
        EssentieleOpties stuurKorting = new EssentieleOpties("Stuur met miliekorting", 500.0 * 0.95);

        essentieleOpties.add(romp);
        essentieleOpties.add(rompKorting);
        essentieleOpties.add(zeilen);
        essentieleOpties.add(zeilenKorting);
        essentieleOpties.add(roer);
        essentieleOpties.add(roerKorting);
        essentieleOpties.add(mast);
        essentieleOpties.add(mastKorting);
        essentieleOpties.add(zwaard);
        essentieleOpties.add(zwaardKorting);
        essentieleOpties.add(stuur);
        essentieleOpties.add(stuurKorting);

        Scanner input = new Scanner(System.in);

        EssentieleOpties rompBonus = new EssentieleOpties("Romp", 1500.0);
        EssentieleOpties zeilenBonus = new EssentieleOpties("Zeilen", 2700.0);
        EssentieleOpties roerBonus = new EssentieleOpties("Roer", 800.0);
        EssentieleOpties mastBonus = new EssentieleOpties("Mast", 1350.0);
        EssentieleOpties zwaardBonus = new EssentieleOpties("Zwaard", 1150.0);
        EssentieleOpties stuurBonus = new EssentieleOpties("Stuur", 350.0);

        randomKorting.add(rompBonus);
        randomKorting.add(zeilenBonus);
        randomKorting.add(roerBonus);
        randomKorting.add(mastBonus);
        randomKorting.add(zwaardBonus);
        randomKorting.add(stuurBonus);

        Random rand = new Random();
        int randomIndex = rand.nextInt(6);
        EssentieleOpties randomOptie = null;
        switch (randomIndex) {
            case 0:
                randomOptie = rompBonus;
                break;
            case 1:
                randomOptie = zeilenBonus;
                break;
            case 2:
                randomOptie = roerBonus;
                break;
            case 3:
                randomOptie = mastBonus;
                break;
            case 4:
                randomOptie = zwaardBonus;
                break;
            case 5:
                randomOptie = stuurBonus;
                break;
        }
        System.out.println("\nLaten we beginnen met het opstellen van je offerte!\n");

        //bonusartikel keuze
        System.out.println("Gefeliciteerd! Je hebt een bonus korting gekregen: " + randomOptie.getNaam() + " met korting van 10%! De prijs hiervan is: " + randomOptie.getPrijs());
        System.out.println("Wil je deze optie toevoegen? Typ 'ja' of 'nee'.");
        String antwoord = input.next();
        if (antwoord.equalsIgnoreCase("ja")) {
            gekozenEssentieleOpties.add(randomOptie);
            System.out.println("Optie '" + randomOptie.getNaam() + "' is toegevoegd. Sla het kiezen van je bonusartikel over bij het kiezen van je componenten.\n");
        } else {
            System.out.println("\nOptie niet toegevoegd.");
        }

        System.out.println("Hier kiezen we de essentiële componenten voor uw boot. Kies bij ieder artikel of u milieukorting heeft of niet.\n");
        //normale artikelen kiezen
        while (true) {
            System.out.println("Kies een optie:");
            for (int i = 0; i < essentieleOpties.size(); i++) {
                System.out.println((i + 1) + ". " + essentieleOpties.get(i).getNaam() + " - " + essentieleOpties.get(i).getPrijs());
            }
            System.out.println("0. Stop met kiezen");

            int keuze = input.nextInt();
            if (keuze == 0) {
                break;
            }

            if (keuze > 0 && keuze <= essentieleOpties.size()) {
                Optie gekozenOptie = essentieleOpties.get(keuze - 1);
                gekozenEssentieleOpties.add((EssentieleOpties) gekozenOptie);
                System.out.println("Optie '" + gekozenOptie.getNaam() + "' is toegevoegd.");
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }

// Bereken de totale prijs van de gekozen opties
        for (Optie optie : gekozenEssentieleOpties) {
            essentieleOptiesPrijs += optie.getPrijs();
        }
        System.out.println("de prijs van de essentiële opties: " + essentieleOptiesPrijs);
    }

    public void ExtraOptiesToevoegen() {
        ExtraOpties anker = new ExtraOpties("Anker", 100.0);
        ExtraOpties navigatie = new ExtraOpties("Navigatie", 500.0);
        ExtraOpties zwemtrap = new ExtraOpties("Zwemtrap", 200.0);
        ExtraOpties reddingsboei = new ExtraOpties("Reddingsboei", 50.0);
        ExtraOpties radio = new ExtraOpties("Radio", 300.0);
        ExtraOpties dieptemeter = new ExtraOpties("Dieptemeter", 400.0);
        ExtraOpties radar = new ExtraOpties("Radar", 800.0);
        ExtraOpties kompas = new ExtraOpties("Kompas", 150.0);
        ExtraOpties marifoon = new ExtraOpties("Marifoon", 600.0);
        ExtraOpties zonnedek = new ExtraOpties("Zonnedek", 1000.0);
        ExtraOpties ankerKorting = new ExtraOpties("Anker met miliekorting", 100.0 * 0.95);
        ExtraOpties navigatieKorting = new ExtraOpties("Navigatie met miliekorting", 500.0 * 0.95);
        ExtraOpties zwemtrapKorting = new ExtraOpties("Zwemtrap met miliekorting", 200.0 * 0.95);
        ExtraOpties reddingsboeiKorting = new ExtraOpties("Reddingsboei met miliekorting", 50.0 * 0.95);
        ExtraOpties radioKorting = new ExtraOpties("Radio met miliekorting", 300.0 * 0.95);
        ExtraOpties dieptemeterKorting = new ExtraOpties("Dieptemeter met miliekorting", 400.0 * 0.95);
        ExtraOpties radarKorting = new ExtraOpties("Radar met miliekorting", 800.0 * 0.95);
        ExtraOpties kompasKorting = new ExtraOpties("Kompas met miliekorting", 150.0 * 0.95);
        ExtraOpties marifoonKorting = new ExtraOpties("Marifoon met miliekorting", 600.0 * 0.95);
        ExtraOpties zonnedekKorting = new ExtraOpties("Zonnedek met miliekorting", 1000.0 * 0.95);

        extraOpties.add(anker);
        extraOpties.add(ankerKorting);
        extraOpties.add(navigatie);
        extraOpties.add(navigatieKorting);
        extraOpties.add(zwemtrap);
        extraOpties.add(zwemtrapKorting);
        extraOpties.add(reddingsboei);
        extraOpties.add(reddingsboeiKorting);
        extraOpties.add(radio);
        extraOpties.add(radioKorting);
        extraOpties.add(dieptemeter);
        extraOpties.add(dieptemeterKorting);
        extraOpties.add(radar);
        extraOpties.add(radarKorting);
        extraOpties.add(kompas);
        extraOpties.add(kompasKorting);
        extraOpties.add(marifoon);
        extraOpties.add(marifoonKorting);
        extraOpties.add(zonnedek);
        extraOpties.add(zonnedekKorting);

        System.out.println("Hier kiezen we de extra componenten voor uw boot. Kies hoeveel componenten als u wilt! Kies bij ieder artikel of u milieukorting heeft of niet.\n");

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Kies een optie:\n");
            for (int i = 0; i < extraOpties.size(); i++) {
                System.out.println((i + 1) + ". " + extraOpties.get(i).getNaam() + " - " + extraOpties.get(i).getPrijs());
            }
            System.out.println("0. Stop met kiezen");

            int keuze = input.nextInt();
            if (keuze == 0) {
                break;
            }

            if (keuze > 0 && keuze <= extraOpties.size()) {
                Optie gekozenOptie = extraOpties.get(keuze - 1);
                gekozenExtraOpties.add((ExtraOpties) gekozenOptie);
                System.out.println("\nOptie '" + gekozenOptie.getNaam() + "' is toegevoegd.");
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
            for (Optie optie : gekozenExtraOpties) {
                extraOptiesPrijs += optie.getPrijs();
            }
            System.out.println("\nde prijs van de extra opties: " + extraOptiesPrijs);
        }
    }


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

        double totaalPrijs = beginPrijs + extraOptiesPrijs + essentieleOptiesPrijs * klantTypeKorting;

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
        for (ExtraOpties optie : gekozenExtraOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getPrijs());
        }
        System.out.println("Prijs van de extra opties bij elkaar: " + extraOptiesPrijs);
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
