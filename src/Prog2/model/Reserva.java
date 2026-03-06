package Prog2.model;
import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva implements InReserva{
    private Client client;
    private Allotjament allotjament;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    /**
     * Constructor d'objectes de la classe Reserva.
     * @param allotjament allotjament on es vol efectuar la reserva.
     * @param client client que vol efectuar la reserva.
     * @param dataEntrada data d'entrada a l'allotjament.
     * @param dataSortida data de sortida de l'allotjament.
     * @throws ExcepcioReserva si la data de sortida és abans de la data d'entrada.
     */
    public Reserva( Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        this.dataSortida = dataSortida;
        this.dataEntrada = dataEntrada;
        this.client = client;
        this.allotjament = allotjament;
        if (dataEntrada.isAfter(dataSortida)){
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
    }

    @Override
    public Allotjament getAllotjament_() {
        return allotjament;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    @Override
    public LocalDate getDataSortida() {
        return dataSortida;
    }

    @Override
    public void setAllotjament_(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    @Override
    public void setClient(Client client_) {
        this.client = client_;
    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada_) {
        this.dataEntrada = dataEntrada_;
    }

    @Override
    public void setDataSortida(LocalDate dataSortida_) {
        this.dataSortida = dataSortida_;
    }
}
