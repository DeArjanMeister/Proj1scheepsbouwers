import java.util.ArrayList;
import java.util.Scanner;

public class Offertemaker {
    private int beginPrijs = 10000;

public void offertemaken(){
    EssentieleOptiesToevoegen();
    ExtraOptiesToevoegen();


}

private void EssentieleOptiesToevoegen(){
    EssentieleOpties romp = new EssentieleOpties("Romp", 2000.0);
    EssentieleOpties zeilen = new EssentieleOpties("Zeilen", 3000.0);
    EssentieleOpties roer = new EssentieleOpties("Roer", 1000.0);
    EssentieleOpties mast = new EssentieleOpties("Mast", 1500.0);
    EssentieleOpties zwaard = new EssentieleOpties("Zwaard", 1200.0);
    EssentieleOpties stuur = new EssentieleOpties("Stuur", 500.0 );
    EssentieleOpties rompKorting = new EssentieleOpties("Romp met miliekorting", 2000.0 * 0.95);
    EssentieleOpties zeilenKorting = new EssentieleOpties("Zeilen met miliekorting", 3000.0 * 0.95);
    EssentieleOpties roerKorting = new EssentieleOpties("Roer met miliekorting", 1000.0 * 0.95);
    EssentieleOpties mastKorting = new EssentieleOpties("Mast met miliekorting", 1500.0 * 0.95);
    EssentieleOpties zwaardKorting = new EssentieleOpties("Zwaard met miliekorting", 1200.0 * 0.95);
    EssentieleOpties stuurKorting = new EssentieleOpties("Stuur met miliekorting", 500.0 * 0.95);

    ArrayList<EssentieleOpties> essentieleOpties = new ArrayList<>();
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
    ArrayList<EssentieleOpties> gekozenOpties = new ArrayList<>();
    while (true) {
        System.out.println("Kies een optie:");
        for (int i = 0; i < essentieleOpties.size(); i++) {
            System.out.println((i+1) + ". " + essentieleOpties.get(i).getNaam() + " - " + essentieleOpties.get(i).getPrijs());
        }
        System.out.println("0. Stop met kiezen");

        int keuze = input.nextInt();
        if (keuze == 0) {
            break;
        }

        if (keuze > 0 && keuze <= essentieleOpties.size()) {
            Optie gekozenOptie = essentieleOpties.get(keuze-1);
            gekozenOpties.add((EssentieleOpties) gekozenOptie);
            System.out.println("Optie '" + gekozenOptie.getNaam() + "' is toegevoegd.");
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
    }

// Bereken de totale prijs van de gekozen opties
    double essentieleOptiesPrijs = 0.0;
    for (Optie optie : gekozenOpties) {
        essentieleOptiesPrijs += optie.getPrijs();
    }
    System.out.println("de prijs van de essentiële opties: " + essentieleOptiesPrijs);
}
private void ExtraOptiesToevoegen(){
    ExtraOpties anker = new ExtraOpties("Anker met miliekorting", 100.0);
    ExtraOpties navigatie = new ExtraOpties("Navigatie met miliekorting", 500.0);
    ExtraOpties zwemtrap = new ExtraOpties("Zwemtrap met miliekorting", 200.0);
    ExtraOpties reddingsboei = new ExtraOpties("Reddingsboei met miliekorting", 50.0);
    ExtraOpties radio = new ExtraOpties("Radio met miliekorting", 300.0);
    ExtraOpties dieptemeter = new ExtraOpties("Dieptemeter met miliekorting", 400.0);
    ExtraOpties radar = new ExtraOpties("Radar met miliekorting", 800.0);
    ExtraOpties kompas = new ExtraOpties("Kompas met miliekorting", 150.0);
    ExtraOpties marifoon = new ExtraOpties("Marifoon met miliekorting", 600.0);
    ExtraOpties zonnedek = new ExtraOpties("Zonnedek met miliekorting", 1000.0);
    ExtraOpties ankerKorting = new ExtraOpties("Anker met miliekorting", 100.0);
    ExtraOpties navigatieKorting = new ExtraOpties("Navigatie met miliekorting", 500.0);
    ExtraOpties zwemtrapKorting = new ExtraOpties("Zwemtrap met miliekorting", 200.0);
    ExtraOpties reddingsboeiKorting = new ExtraOpties("Reddingsboei met miliekorting", 50.0);
    ExtraOpties radioKorting = new ExtraOpties("Radio met miliekorting", 300.0);
    ExtraOpties dieptemeterKorting = new ExtraOpties("Dieptemeter met miliekorting", 400.0);
    ExtraOpties radarKorting = new ExtraOpties("Radar met miliekorting", 800.0);
    ExtraOpties kompasKorting = new ExtraOpties("Kompas met miliekorting", 150.0);
    ExtraOpties marifoonKorting = new ExtraOpties("Marifoon met miliekorting", 600.0);
    ExtraOpties zonnedekKorting = new ExtraOpties("Zonnedek met miliekorting", 1000.0);

    ArrayList<ExtraOpties> extraOpties = new ArrayList<>();
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

    ArrayList<ExtraOpties> gekozenOpties = new ArrayList<>();
    while (true) {
        Scanner input = new Scanner(System.in);
        System.out.println("Kies een optie:");
        for (int i = 0; i < extraOpties.size(); i++) {
            System.out.println((i+1) + ". " + extraOpties.get(i).getNaam() + " - " + extraOpties.get(i).getPrijs());
        }
        System.out.println("0. Stop met kiezen");

        int keuze = input.nextInt();
        if (keuze == 0) {
            break;
        }

        if (keuze > 0 && keuze <= extraOpties.size()) {
            Optie gekozenOptie = extraOpties.get(keuze-1);
            gekozenOpties.add((ExtraOpties) gekozenOptie);
            System.out.println("Optie '" + gekozenOptie.getNaam() + "' is toegevoegd.");
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
    }
}

    private void printGekozenEssentieleOpties(ArrayList<EssentieleOpties> gekozenEssentieleOpties) {
        System.out.println("Gekozen extra opties:");
        for (EssentieleOpties optie : gekozenEssentieleOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getPrijs());
        }
    }
    private void printGekozenExtraOpties(ArrayList<ExtraOpties> gekozenExtraOpties) {
        System.out.println("Gekozen extra opties:");
        for (ExtraOpties optie : gekozenExtraOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getPrijs());
        }
    }

private void OfferteMaken(){

    // Maak klant en voeg opties toe
    Klant klant = new Klant();

    // Bereken totaalprijs en print offerte
    double totaalPrijs = klant.berekenTotaalPrijs(boot);
    System.out.println("Offerte voor " + boot.getNaam() + ":");
    System.out.println("- Standaardprijs: €" + boot.getStandaardPrijs());
    System.out.println("- Essentiële opties:");
    for (Optie optie : boot.getEssentiëleOpties()) {
        System.out.println("  - " + optie.getNaam() + ": €" + optie.getPrijs());
    }
    System.out.println("- Extra opties:");
    for (Optie optie : boot.getExtraOpties()) {
        System.out.println("  - " + optie.getNaam() + ": €" + optie.getPrijs());
    }
    System.out.println("- Geselecteerde opties:");
    for (Optie optie : klant.getGeselecteerdeOpties())
}

}
