package Prog2.model;

public class Client implements InClient{
    private String nom;
    private String dni;

    /**
     * Constructor d'objectes de la classe Client.
     * @param nom nom del client.
     * @param dni DNI del client.
     */
    public Client(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString(){
        return nom + " amb DNI: " + dni + ". ";
    }
}
