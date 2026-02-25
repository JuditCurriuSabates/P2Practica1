package Prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;
    private long estadaMinima;

    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
        estadaMinima = 3;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + id + ", Estada mínim en temp " + enumA + ": " + estadaMinima + ", Estada mínima en temp " +
                enumB + ": " + estadaMinima2 + ". Casa => Glàmping { Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Material = " + material + ", Casa de mascotes = " + casaMascota + "}";

        return info;
    }
}
