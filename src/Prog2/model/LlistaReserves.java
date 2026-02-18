package Prog2.model;

import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class LlistaReserves implements InLlistaReserves{
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

    }

    @Override
    public int getNumReserves() {
        return 0;
    }
}
