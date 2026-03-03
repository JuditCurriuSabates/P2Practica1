package Prog2.model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;


    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        super(nom, idAllotjament, 4, 2);
        this.connexioElectrica = connexioElectrica;
        this.metres = metres;
    }
    public float getMida(){
        return metres;
    }

    public void setMida(float metres){
        this.metres = metres;
    }

    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

    @Override
    public String toString() {
        String info;

        info = super.toString();
        info += " Parcel·la {Mida = " + metres + ", Connexió elèctrica = " + connexioElectrica + "}";

        return info;
    }

    public boolean isConnexioElectrica(){
        return connexioElectrica;
    }

    public void setConnexioElectrica(boolean connexioElectrica){
        this.connexioElectrica = connexioElectrica;
    }

}
