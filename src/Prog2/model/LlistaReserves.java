package Prog2.model;

import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> reserves;

    LlistaReserves() {
        reserves = new ArrayList<Reserva>();
    }

    public ArrayList<Reserva> getReserves() {
        return reserves;
    }

    public void setReserves(ArrayList<Reserva> reserves) {
        this.reserves = reserves;
    }

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
        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        reserves.add(novaReserva);

    }

    @Override
    public int getNumReserves() {
        return reserves.size();
    }

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        boolean trobat = false;
        String id = allotjament.getId();
        Iterator<Reserva> it = reserves.iterator();
        Reserva reserva = null;

        while (it.hasNext() && !trobat) {
            Reserva r = it.next();

            if (((r.getAllotjament_()).getId()).equals(id)) {
                trobat = true;
                reserva = r;
            }
        }

        if (trobat) {
            if (dataEntrada.isAfter(reserva.getDataEntrada()) && dataEntrada.isBefore(reserva.getDataSortida())) {
                return false;
            } else if (dataSortida.isAfter(reserva.getDataEntrada()) && dataSortida.isBefore(reserva.getDataSortida())) {
                return false;
            } else if (dataEntrada.isBefore(reserva.getDataEntrada()) && dataSortida.isAfter(reserva.getDataSortida())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        boolean minima;

        minima = (allotjament.getEstadaMinima(Camping.getTemporada(dataEntrada)) <= estada);

        return minima;
    }
}