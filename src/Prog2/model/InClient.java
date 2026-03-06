package Prog2.model;

public interface InClient {
    /**
     * Obté el nom del client.
     * @return el nom del client.
     */
    public String getNom();

    /**
     * Obté el DNI del client.
     * @return el DNI del client.
     */
    public String getDni();

    /**
     * Estableix el nom del client.
     * @param nom el nom del client
     */
    public void setNom(String nom);

    /**
     * Estableix el DNI del client.
     * @param dni el DNI del client
     */
    public void setDni(String dni);


}
