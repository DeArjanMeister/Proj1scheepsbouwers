import java.util.ArrayList;

public class Klant {
    private ArrayList<Optie> geselecteerdeOpties = new ArrayList<>();

    public void voegOptieToe(Optie optie) {
        geselecteerdeOpties.add(optie);
    }

    public void verwijderOptie(Optie optie) {
        geselecteerdeOpties.remove(optie);
    }

    public ArrayList<Optie> getGeselecteerdeOpties() {
        return geselecteerdeOpties;
    }

//    public double berekenTotaalPrijs(Boot boot) {
//        double totaalPrijs = boot.berekenPrijs();
//
//        // Bereken prijs van geselecteerde opties
//        for (Optie optie : geselecteerdeOpties) {
//            totaalPrijs += optie.getPrijs();
//        }
//
//        return totaalPrijs;
//    }
}