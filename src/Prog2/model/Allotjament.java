package Prog2.model;

public abstract class Allotjament implements InAllotjament {
    protected String nom;
    protected String idAllotjament;
    protected long estadaMinimaALTA;
    protected long estadaMinimaBAIXA;
    protected long estada;

    /**
     * Constructor d'objectes de la classe Casa.
     * @param nom nom de l'allotjament.
     * @param idAllotjament ID de l'allotjament.
     * @param estadaMinimaALTA estada mínima de l'allotjament en temporada alta.
     * @param estadaMinimaBAIXA estada mínima de l'allotjament en temporada baixa.
     */
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
        switch (temp) {
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

    /**
     * Passa tota la informació relacionada amb un allotjament a String perquè es pugui imprimir
     * @return l'String que conté la informació
     */
    @Override
    public String toString() {
        return "Nom=" + nom +", Id=" + idAllotjament + ", estada mínima en temp " + Temp.ALTA + ": " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp " + Temp.BAIXA + ": " + getEstadaMinima(Temp.BAIXA) + ".";
    }
}
