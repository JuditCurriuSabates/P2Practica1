package Prog2.model;

public class BungalowPremium extends Bungalow{
    private String codiWifi;
    private boolean serveisExtra;

    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    @Override
    public boolean correcteFuncionament() {
    boolean correcte = false;

    if (aireFred && codiWifi.length() >= 8 && codiWifi.length()<= 16) {
        correcte = true;
    }

    return correcte;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + idAllotjament + ", Estada mínim en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) + ", Estada mínima en temp " +
                Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ". Casa => Bungalow => Bungalow prèmium { Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Places pàrquing = " + placesParquing + ", Terrassa = " + terrassa + ", TV = " +  tv + ", Aire fred = " + aireFred +
                ", Serveis extra = " + serveisExtra + ", Codi wifi = " + codiWifi + "}";

        return info;
    }
}
