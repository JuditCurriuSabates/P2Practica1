package Prog2.model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;


    /**
     * Constructor d'objectes de la classe Parcela.
     * @param nom nom de l'allotjament.
     * @param idAllotjament ID de l'allotjament.
     * @param metres mida de l'allotjament.
     * @param connexioElectrica si l'allotjament té connexió elèctrica o no.
     */
    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        super(nom, idAllotjament, 4, 2);
        this.connexioElectrica = connexioElectrica;
        this.metres = metres;
    }

    /**
     * Obté la mida de la parcel·la.
     * @return la mida de la parcel·la.
     */
    public float getMida(){
        return metres;
    }

    /**
     * Estableix la mida de la parcel·la.
     * @param metres la mida a assignar.
     */
    public void setMida(float metres){
        this.metres = metres;
    }

    // Sobreescriu el mètode toString de la classe de la qual hereta (Allotjament)
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

    // Sobreescriu el mètode toString de la classe de la qual hereta (Allotjament)
    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += " Parcel·la {Mida = " + metres + ", Connexió elèctrica = " + connexioElectrica + "}";

        return info;
    }

    /**
     * Obté si la parcel·la té connexió elèctrica.
     * @return si la parcel·la té connexió elèctrica.
     */
    public boolean isConnexioElectrica(){
        return connexioElectrica;
    }

    /**
     * Estableix si la parcel·la té connexió elèctrica.
     * @param connexioElectrica si la parcel·la té connexió elèctrica o no.
     */
    public void setConnexioElectrica(boolean connexioElectrica){
        this.connexioElectrica = connexioElectrica;
    }

}
