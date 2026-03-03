package Prog2.model;

public class BungalowPremium extends Bungalow{
    private String codiWifi;
    private boolean serveisExtra;

    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    public boolean getServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
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

        info = super.toString();
        info += ", Serveis extra = " + serveisExtra + ", Codi wifi = " + codiWifi + "}";

        return info;
    }
}
