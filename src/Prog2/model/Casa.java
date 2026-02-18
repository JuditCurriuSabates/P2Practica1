package Prog2.model;

public class Casa extends Allotjament{

    private long mida;
    private int numHabitacions;
    private int capacitat;

    public Casa(long mida, int numHabitacions, int capacitat){
        this.mida =mida;
        this.numHabitacions = numHabitacions;
        this.capacitat = capacitat;
    }
}
