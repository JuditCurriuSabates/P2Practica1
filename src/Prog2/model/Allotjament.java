package Prog2.model;

public abstract class Allotjament implements InAllotjament{
    protected String nom;
    protected String idAllotjament;
    private long estadaMinima;

    public Allotjament(String nom, String idAllotjament, long estadaMinima){
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinima = estadaMinima;
    }
    public Allotjament(){
        this.nom = "A";
        this.idAllotjament = "ED";
        this.estadaMinima = 4;
    }
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return idAllotjament;
    }

    @Override
    public void setId(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        return 0;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
