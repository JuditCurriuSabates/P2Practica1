package Prog2.model;

import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{
    private ArrayList<Reserva> llistaReserves;
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        boolean disp = allotjamentDisponible(allotjament, dataEntrada, dataSortida);

        if (!disp) {
            throw new ExcepcioReserva("L'allotjament amb ID " + allotjament.getId() + " no està disponible en la data demanada " +
                    dataEntrada + " pel client " + client.getNom() + " amb DNI: " + client.getDni());
        }
        boolean dies = isEstadaMinima(allotjament, dataEntrada, dataSortida);

        if (!dies) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() +
                    " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId());
        }
        if(dies && disp){
            Reserva novaReserva = new Reserva(client, allotjament, dataEntrada, dataSortida);
            llistaReserves.add(novaReserva);
        }

    }

    @Override
    public int getNumReserves() {
        return 0;
    }
}
    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

        return true;
    }
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

        return false;
    }