package Prog2.model;

public abstract class Allotjament implements InAllotjament {
    protected String nom;
    protected String idAllotjament;
    protected long estadaMinimaALTA;
    protected long estadaMinimaBAIXA;
    protected long estada;

    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.estadaMinimaALTA = estadaMinimaALTA;
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
        switch(temp){
            case ALTA:
                return estadaMinimaALTA;
            case BAIXA:
                return estadaMinimaBAIXA;
            default: return 0;
        }

    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }

    @Override
    public String toString() {
        return "Nom=" + nom +", Id=" + idAllotjament + ", estada mínima en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp " + Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ".";
    }
}
