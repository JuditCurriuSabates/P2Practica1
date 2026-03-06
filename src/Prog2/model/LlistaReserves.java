package Prog2.model;

import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> reserves;

    /**
     * Constructor d'objectes de la classe LlistaReserves. Crea una nova llista de tipus ArrayList.
     */
    LlistaReserves() {
        reserves = new ArrayList<Reserva>();
    }

    /**
     * Obté la llista de reserves.
     * @return la llista de reserves.
     */
    public ArrayList<Reserva> getReserves() {
        return reserves;
    }

    /**
     * Crea una nova llista de reserves.
     * @param reserves la nova llista de reserves.
     */
    public void setReserves(ArrayList<Reserva> reserves) {
        this.reserves = reserves;
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        boolean disp = allotjamentDisponible(allotjament, dataEntrada, dataSortida);

        if (dataEntrada.isAfter(dataSortida)) {
            // Comprova que la data d'entrada sigui abans de la de sortida
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }

        if (!disp) {
            // Comprova que l'allotjament estigui disponible els dies indicats
            throw new ExcepcioReserva("L'allotjament amb ID " + allotjament.getId() + " no està disponible en la data demanada " +
                    dataEntrada + " pel client " + client.getNom() + " amb DNI: " + client.getDni());
        }
        boolean dies = isEstadaMinima(allotjament, dataEntrada, dataSortida);

        if (!dies) {
            // Comprova que l'estada demanada sigui més gran que l'estada mínima a la temporada demanada
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

    /**
     * Comprova si un allotjament està disponible en unes dates determinades.
     * @param allotjament l'allotjament on es vol fer la reserva.
     * @param dataEntrada la data d'entrada sol·licitada pel client.
     * @param dataSortida la data de sortida sol·licitada pel client.
     * @return si l'allotjament està disponible.
     */
    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        boolean trobat = false;
        String id = allotjament.getId();
        Iterator<Reserva> it = reserves.iterator();
        Reserva reserva = null;

        while (it.hasNext() && !trobat) {
            // Comprova que l'allotjament on es vol fer la reserva existeixi
            Reserva r = it.next();

            if (((r.getAllotjament_()).getId()).equals(id)) {
                trobat = true;
                reserva = r;
            }
        }

        if (trobat) {
            // Mira que l'allotjament no està reservat a les dates indicades
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

    /**
     * Comprova si la reserva que es vol fer en un allotjament supera l'estada mínima per aquell allotjament.
     * @param allotjament l'allotjament on es vol fer la reserva.
     * @param dataEntrada la data d'entrada sol·licitada pel client.
     * @param dataSortida la data de sortida sol·licitada pel client.
     * @return si l'estada supera l'estada mínima.
     */
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        boolean minima;

        minima = (allotjament.getEstadaMinima(Camping.getTemporada(dataEntrada)) <= estada);

        return minima;
    }
}