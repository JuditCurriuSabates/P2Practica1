package Prog2.model;

public class Bungalow extends Casa{
    protected int placesParquing;
    protected boolean aireFred;
    protected boolean terrassa;
    protected boolean tv;

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
     */
    public Bungalow(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    /**
     * Obté les places de pàrquing de l'allotjament.
     * @return la quantitat de places de pàrquing de l'allotjament.
     */
    public int getPlacesParquing() {
        return placesParquing;
    }

    /**
     * Estableix la quantitat de places de pàrquing de l'allotjament.
     * @param placesParquing la quantitat de places a assignar
     */
    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    /**
     * Obté si l'allotjament té aire fred.
     * @return si l'allotjament té aire fred.
     */
    public boolean getAireFred() {
        return aireFred;
    }

    /**
     * Estableix si l'allotjament té aire fred.
     * @param aireFred sí l'allotjament té aire fred o no.
     */
    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    /**
     * Obté si l'allotjament té televisió.
     * @return si l'allotjament té televisió.
     */
    public boolean getTv() {
        return tv;
    }

    /**
     * Estableix si l'allotjament té televisió.
     * @param tv sí l'allotjament té televisió no.
     */
    public void setTv(boolean tv) {
        this.tv = tv;
    }

    /**
     * Obté si l'allotjament té terrassa.
     * @return si l'allotjament té terrassa.
     */
    public boolean getTerrasa() {
        return terrassa;
    }

    /**
     * Estableix si l'allotjament té terrassa.
     * @param terrassa sí l'allotjament té terrassa o no.
     */
    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    // Sobreescriu el mètode correcteFuncionament de la classe de la qual hereta (Allotjament)
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    // Sobreescriu el mètode toString de la classe de la qual hereta (Allotjament)
    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += " Casa => Bungalow {Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Places pàrquing = " + placesParquing + ", Terrassa = " + terrassa + ", TV = " +  tv + ", Aire fred = " + aireFred + "}";

        return info;
    }
}
