package Prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;

    /**
     * Constructor d'objectes de la classe Glamping.
     * @param nom nom de l'allotjament.
     * @param idAllotjament ID de l'allotjament.
     * @param mida mida de l'allotjament.
     * @param habitacions número d'habitacions de l'allotjament.
     * @param placesPersones quantitat de places de l'allotjament.
     * @param material material del qual està fet l'allotjament.
     * @param casaMascota si l'allotjament té casa per mascottes o no.
     */
    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, 3, 3, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    /**
     * Obté el material de l'allotjament.
     * @return el material de l'allotjament.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Estableix el material de l'allotjament.
     * @param material el material a assignar
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obté si l'allotjament té casa per mascotes.
     * @return si l'allotjament té casa per mascotes.
     */
    public boolean getCasaMascota() {
        return casaMascota;
    }

    /**
     * Estableix si l'allotjament té casa per mascotes.
     * @param casaMascota sí l'allotjament té casa per mascotes o no.
     */
    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    // Sobreescriu el mètode correcteFuncionament de la classe de la qual hereta (Allotjament)
    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    // Sobreescriu el mètode toString de la classe de la qual hereta (Allotjament)
    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += " Casa => Glàmping {Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Material = " + material + ", Casa de mascotes = " + casaMascota + "}";

        return info;
    }
}
