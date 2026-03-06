package Prog2.model;

public abstract class Casa extends Allotjament{
    protected String mida;
    protected int habitacions;
    protected int placesPersones;

    /**
     * Constructor d'objectes de la classe Casa.
     * @param nom nom de l'allotjament.
     * @param idAllotjament ID de l'allotjament.
     * @param mida mida de l'allotjament.
     * @param habitacions número d'habitacions de l'allotjament.
     * @param placesPersones quantitat de places de l'allotjament
     */
    public Casa(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA,String mida, int habitacions, int placesPersones){
        super(nom, idAllotjament, estadaMinimaALTA, estadaMinimaBAIXA);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    /**
     * Obté la mida de l'allotjament.
     * @return la mida de l'allotjament.
     */
    public String getMida() {
        return mida;
    }

    /**
     * Estableix la mida de l'allotjament.
     * @param mida la mida a assignar
     */
    public void setMida(String mida) {
        this.mida = mida;
    }

    /**
     * Obté la quantitat d'habitacions de l'allotjament.
     * @return la quantitat d'habitacions de l'allotjament.
     */
    public int getHabitacions() {
        return habitacions;
    }

    /**
     * Estableix la quantitat d'habitacions de l'allotjament.
     * @param habitacions la quantitat d'habitacions a assignar
     */
    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    /**
     * Obté la quantitat de places de l'allotjament.
     * @return la quantitat de places de l'allotjament.
     */
    public int getPlacesPersones() {
        return placesPersones;
    }

    /**
     * Estableix la quantitat de places de l'allotjament.
     * @param placesPersones la quantitat de places a assignar
     */
    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }
}
