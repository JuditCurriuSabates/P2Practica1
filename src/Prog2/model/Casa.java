package Prog2.model;

public abstract class Casa extends Allotjament{
    protected String mida;
    protected int habitacions;
    protected int placesPersones;

    public Casa(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA,String mida, int habitacions, int placesPersones){
        super(nom, idAllotjament, estadaMinimaALTA, estadaMinimaBAIXA);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }
}
