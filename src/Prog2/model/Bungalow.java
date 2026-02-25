package Prog2.model;

public class Bungalow extends Casa{
    protected int placesParquing;
    protected boolean aireFred;
    protected boolean terrassa;
    protected boolean tv;
    protected long estadaMinima;

    public Bungalow(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
        //this.estadaMinima = getEstadaMinima(4, 7);
    }

    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + idAllotjament + ", Estada mínim en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) + ", Estada mínima en temp " +
                Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ". Casa => Bungalow { Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Places pàrquing = " + placesParquing + ", Terrassa = " + terrassa + ", TV = " +  tv + ", Aire fred = " + aireFred + "}";

        return info;
    }
}
