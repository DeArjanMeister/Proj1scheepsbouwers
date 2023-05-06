import java.util.ArrayList;

public class Boot {
    private String naam;
    private double standaardPrijs;
    private ArrayList<Optie> essentieleOpties;
    private ArrayList<Optie> extraOpties;

    public Boot(String naam, double standaardPrijs, ArrayList<Optie> essentieleOpties, ArrayList<Optie> extraOpties) {
        this.naam = naam;
        this.standaardPrijs = standaardPrijs;
        this.essentieleOpties = essentieleOpties;
        this.extraOpties = extraOpties;
    }

    public String getNaam() {
        return naam;
    }

    public double getStandaardPrijs() {
        return standaardPrijs;
    }

    public ArrayList<Optie> getEssentiëleOpties() {
        return essentieleOpties;
    }

    public ArrayList<Optie> getExtraOpties() {
        return extraOpties;
    }
//    public double berekenPrijs() {
//        double totaalPrijs = getStandaardPrijs();
//
//        // Bereken prijs van essentiële opties
//        for (Optie optie : getEssentiëleOpties()) {
//            totaalPrijs += optie.getPrijs();
//        }
//
//        // Bereken prijs van extra opties
//        for (Optie optie : getExtraOpties()) {
//            totaalPrijs += optie.getPrijs();
//        }
//
//        return totaalPrijs;
// }
}
