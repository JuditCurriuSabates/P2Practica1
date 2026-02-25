package Prog2.model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;
    private long estadaMinima;

    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        super(nom, idAllotjament);
        this.connexioElectrica = connexioElectrica;
        this.metres = metres;
        //this.estadaMinima = getEstadaMinima(2, 4);
    }

    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

    @Override
    public String toString() {
        String info;

        info = "Nom = " + nom + ", ID = " + idAllotjament + ", Estada mínim en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) + ", Estada mínima en temp " +
                Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ". Parcel·la { Mida = " + metres + ", Connexió elèctrica = " + connexioElectrica + "}";

        return info;
    }

}
