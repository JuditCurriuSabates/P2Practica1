package Prog2.model;

public class Glamping extends Casa{

    private String material;
    private boolean casaMascotes;
    @Override
    public boolean correcteFuncionament() {
        return casaMascotes;
    }
}
