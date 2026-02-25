package Prog2.model;

public abstract class Casa extends Allotjament{

    private String mida;
    private int habitacions;
    private int placesPersones;

    public Casa(String nom, String idAllotjament, String mida, int habitacions, int placesPersones){
        super(nom, idAllotjament);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }
}
