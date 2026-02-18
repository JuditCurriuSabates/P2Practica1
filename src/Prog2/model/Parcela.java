package Prog2.model;

public class Parcela extends Allotjament{

    private float metres;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        this.nom = nom;
        this.connexioElectrica = connexioElectrica;
        this.idAllotjament = idAllotjament;
        this.metres = metres;
    }
}
