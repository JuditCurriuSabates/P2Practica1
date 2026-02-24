package Prog2.model;

public class MobilHome extends Casa{

    private boolean terrassaBarbacoa;
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }
    @Override
    public String toString(){
        String info = "Nom =  " + allotjament.getNom() + ", ID = " + allotjament.getID();
        return info;
    }
}
