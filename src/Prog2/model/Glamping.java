package Prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;
    private long estadaMinima;

    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, 3, 3, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + idAllotjament + ", Estada mínim en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) + ", Estada mínima en temp " +
                Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ". Casa => Glàmping { Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Material = " + material + ", Casa de mascotes = " + casaMascota + "}";

        return info;
    }
}
