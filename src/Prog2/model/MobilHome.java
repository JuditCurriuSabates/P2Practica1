package Prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean getTerrassaBarbacoa() {
        return terrassaBarbacoa;
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + idAllotjament + ", Estada mínim en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) + ", Estada mínima en temp " +
                Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ". Casa => Mobil-home { Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Terrassa amb barbacoa = " + terrassaBarbacoa + "}";

        return info;
    }
}
