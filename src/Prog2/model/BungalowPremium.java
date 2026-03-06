package Prog2.model;

public class BungalowPremium extends Bungalow{
    private String codiWifi;
    private boolean serveisExtra;

    /**
     * Constructor d'objectes de la classe Bungalow.
     * @param nom nom de l'allotjament.
     * @param idAllotjament ID de l'allotjament.
     * @param mida mida de l'allotjament.
     * @param habitacions número d'habitacions de l'allotjament.
     * @param placesPersones quantitat de places de l'allotjament.
     * @param placesParquing quantitat de places de pàrquing de l'allotjament.
     * @param terrassa si l'allotjament té terrassa o no.
     * @param tv si l'allotjament té televisió o no.
     * @param aireFred si l'allotjament té aire fred o no.
     * @param serveisExtra si l'allotjament té serveis extra o no.
     * @param codiWifi el codi del Wifi de l'allotjament.
     */
    public BungalowPremium(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    /**
     * Obté el codi del Wifi de l'allotjament.
     * @return el codi del Wifi de l'allotjament.
     */
    public String getCodiWifi() {
        return codiWifi;
    }

    /**
     * Estableix el codi el Wifi de l'allotjament.
     * @param codiWifi el codi del Wifi a assignar
     */
    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    /**
     * Obté si l'allotjament té serveis extra.
     * @return si l'allotjament té serveis extra.
     */
    public boolean getServeisExtra() {
        return serveisExtra;
    }

    /**
     * Estableix si l'allotjament té serveis extra.
     * @param serveisExtra sí l'allotjament té serveis extra no.
     */
    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    // Sobreescriu el mètode correcteFuncionament de la classe de la qual hereta (Bungalow)
    @Override
    public boolean correcteFuncionament() {
    boolean correcte = false;

    if (aireFred && codiWifi.length() >= 8 && codiWifi.length()<= 16) {
        correcte = true;
    }
    return correcte;
    }

    // Sobreescriu el mètode toString de la classe de la qual hereta (Bungalow)
    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += ", Serveis extra = " + serveisExtra + ", Codi wifi = " + codiWifi + "}";

        return info;
    }
}
