package Prog2.model;

public class Parcela extends Allotjament{

    private float metres;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        super(nom, idAllotjament);
        this.connexioElectrica = connexioElectrica;
        this.metres = metres;
    }

    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

}
