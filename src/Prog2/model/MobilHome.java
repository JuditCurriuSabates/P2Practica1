package Prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa;

    /**
     * Constructor d'objectes de la classe MobilHome.
     * @param nom nom de l'allotjament.
     * @param idAllotjament ID de l'allotjament.
     * @param mida mida de l'allotjament.
     * @param habitacions número d'habitacions de l'allotjament.
     * @param placesPersones quantitat de places de l'allotjament.
     * @param terrassaBarbacoa si l'allotjament té terrassa amb barbacoa o no.
     */
    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    /**
     * Obté si l'allotjament té terrassa amb barbacoa.
     * @return si l'allotjament té terrassa amb barbacoa.
     */
    public boolean getTerrassaBarbacoa() {
        return terrassaBarbacoa;
    }

    /**
     * Estableix si l'allotjament té terrassa amb barbacoa.
     * @param terrassaBarbacoa sí l'allotjament té terrassa amb barbacoa o no.
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Sobreescriu el mètode correcteFuncionament de la classe de la qual hereta (Allotjament)
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    // Sobreescriu el mètode correcteFuncionament de la classe de la qual hereta (Allotjament)
    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += " Casa => Mobil-home {Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Terrassa amb barbacoa = " + terrassaBarbacoa + "}";

        return info;
    }
}
