package Prog2.model;

public class BungalowPremium extends Bungalow{
    String wifi;
    @Override
    public boolean correcteFuncionament() {
        boolean correcte = false;
        if(aire && wifi.length() >= 8 && wifi.length()<= 16){
            correcte = true;
        }

        return correcte;

    }
}
