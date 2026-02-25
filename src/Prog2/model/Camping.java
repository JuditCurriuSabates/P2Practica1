package Prog2.model;

import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.*;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Client> llistaClients;
    private LlistaReserves llistaReserves;

    public Camping(String nom){
        this.nom = nom;
        this.llistaAllotjaments = new ArrayList<Allotjament>();
        this.llistaClients = new ArrayList<Client>();
        LlistaReserves llistaReserves = new LlistaReserves();
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    @Override
    public int getNumAllotjaments() {
        return llistaAllotjaments.size();
    }

    @Override
    public int getNumReserves() {
        return llistaReserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return llistaClients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_, dni_);
        llistaClients.add(client);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.add(parcela);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(bungalow);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(bungalowPremium);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(glamping);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(mobilHome);
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = null;
        Client client = null;

        allotjament = buscarAllotjament(id_);
        client = buscarClient(dni_);

        if (allotjament == null || client == null) {
            throw new ExcepcioReserva("No es pot afegir la reserva");
        } else {
            llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
        }
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        Iterator<Allotjament> it = llistaAllotjaments.iterator();

        while (it.hasNext()) {
            Allotjament a = it.next();

            if (a.correcteFuncionament()) {
                comptador ++;
            }
        }

        return comptador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        return null;
    }

    private Allotjament buscarAllotjament(String idAllotjament) {
        boolean trobatA = false;
        Allotjament allotjamentTrobat = null;
        Iterator<Allotjament> ita = llistaAllotjaments.iterator();

        while (ita.hasNext() && !trobatA) {
            Allotjament a = ita.next();

            if ((a.getId()).equals(idAllotjament)) {
                trobatA = true;
                allotjamentTrobat = a;
            }
        }

        return allotjamentTrobat;
    }

    private Client buscarClient(String dni){
        boolean trobatC = false;
        Client clientTrobat = null;
        Iterator<Client> itc = llistaClients.iterator();

        while (itc.hasNext() && !trobatC) {
            Client c = itc.next();

            if ((c.getDni()).equals(dni)) {
                trobatC = true;
                clientTrobat = c;
            }
        }

        return clientTrobat;
    }
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        if (mes < 3 || mes > 9) {
            return InAllotjament.Temp.BAIXA;
        } else if (mes > 3 && mes < 9) {
            return InAllotjament.Temp.ALTA;
        } else if (mes == 3) {
            if (dia < 21)
                return InAllotjament.Temp.BAIXA;
            else
                return InAllotjament.Temp.ALTA;
        } else {
            if (dia < 21)
                return InAllotjament.Temp.ALTA;
            else
                return InAllotjament.Temp.BAIXA;
        }
    }
}
