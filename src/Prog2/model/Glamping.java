package Prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;

    public Glamping(String nom, String idAllotjament, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, 3, 3, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean getCasaMascota() {
        return casaMascota;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += " Casa => Glàmping {Mida = " + mida + ", Habitacions = " + habitacions + ", Capacitat = " +
                placesPersones + ", Material = " + material + ", Casa de mascotes = " + casaMascota + "}";

        return info;
    }
}
