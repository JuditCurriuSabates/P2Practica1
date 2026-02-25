package Prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa;
    private long estadaMinima;

    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
        this.estadaMinima = getEstadaMinima(3, 5);
    }

    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + id + ", Estada mínim en temp " + enumA + ": " + estadaMinima + ", Estada mínima en temp " +
                enumB + ": " + estadaMinima2 + ". Casa => Mobil-home { Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Terrassa amb barbacoa = " + terrassaBarbacoa + "}";

        return info;
    }
}
