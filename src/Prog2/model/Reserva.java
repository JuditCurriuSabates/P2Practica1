package Prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva implements InReserva{
    private Client client;
    private Allotjament allotjament;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

    public Reserva(Client client, Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        this.dataSortida = dataSortida;
        this.dataEntrada = dataEntrada;
        this.client = client;
        this.allotjament = allotjament;
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
        this.allotjament = allotjament;
    }

    @Override
    public void setClient(Client client_) {
        this.client = client;
    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada_) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public void setDataSortida(LocalDate dataSortida_) {
        this.dataSortida = dataSortida;
    }
}
