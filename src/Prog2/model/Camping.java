package Prog2.model;

import Prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.*;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Client> llistaClients;
    private LlistaReserves llistaReserves;

    /**
     * Constructor d'objectes de la classe Camping. Crea, a més a més, dos objectes d'ArrayList i un de LlistaReserves
     * @param nom nom del càmping.
     */
    public Camping(String nom){
        this.nom = nom;
        this.llistaAllotjaments = new ArrayList<>();
        this.llistaClients = new ArrayList<>();
        this.llistaReserves = new LlistaReserves();
    }

    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Estableix el nom del càmping.
     * @param nom el nom a assignar
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

    /**
     * Crea una nova llista de reserves.
     * @param llistaReserves la nova llista de reserves
     */
    public void setLlistaReserves(LlistaReserves llistaReserves) {
        this.llistaReserves = llistaReserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    /**
     * Crea una nova llista d'allotjaments.
     * @param llistaAllotjaments la nova llista d'allotjaments.
     */
    public void setLlistaAllotjaments(ArrayList<Allotjament> llistaAllotjaments) {
        this.llistaAllotjaments = llistaAllotjaments;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    /**
     * Crea una nova llista de clients.
     * @param llistaClients la nova llista de clients
     */
    public void setLlistaClients(ArrayList<Client> llistaClients) {
        this.llistaClients = llistaClients;
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
        System.out.println(client.toString());
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.add(parcela);
        System.out.println(parcela.toString());
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(bungalow);
        System.out.println(bungalow.toString());
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(bungalowPremium);
        System.out.println(bungalowPremium.toString());
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(glamping);
        System.out.println(glamping.toString());
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(mobilHome);
        System.out.println(mobilHome.toString());
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament;
        Client client;

        allotjament = buscarAllotjament(id_);
        client = buscarClient(dni_);

        // Comprova que l'allotjament i el client existeixin
        if (allotjament == null){
            throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");
        } else if (client == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
        } else {
            llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
        }
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        Iterator<Allotjament> it = llistaAllotjaments.iterator();

        while (it.hasNext()) {
            // Recorre la llista d'allotjaments i comprova, per cada allotjament, la seva operativitat
            Allotjament a = it.next();
            if (a.correcteFuncionament()) {
                comptador ++;
            }
        }

        return comptador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Allotjament allotjamentMinim = null;
        Iterator<Allotjament> ita = llistaAllotjaments.iterator();
        long minim = Integer.MAX_VALUE;
        long possibleMinim;

        while (ita.hasNext()) {
            // Recorre la llista d'allotjaments
            Allotjament a = ita.next();
            possibleMinim = a.getEstadaMinima(temp);

            if (possibleMinim < minim ) {
                // Si l'estada mínima actual és menor que l'anterior, es guarda la nova estada mínima i l'allotjament
                minim = possibleMinim;
                allotjamentMinim = a;
            }
        }
        return allotjamentMinim;
    }

    /**
     * Suma la mida de cada parcel·la de la llista d'allotjaments per obtenir-ne el total.
     * @return la mida total de les parcel·les del càmping.
     */
    public float midaTotalParceles(){
        float midaTotal = 0;
        Iterator<Allotjament> ita = llistaAllotjaments.iterator();

        while (ita.hasNext()) {
            // Recorre la llista d'allotjaments
            Allotjament a = ita.next();

            if (a instanceof Parcela) {
                // Filtra els allotjaments de la classe parcel·la, els fa un downcast i n'obté la mida
                Parcela p = (Parcela) a;
                midaTotal+= p.getMida();
            }
        }
        return midaTotal;
    }

    /**
     * Busca si un allotjament existeix a la llista d'allotjaments.
     * @param idAllotjament l'ID de l'allotjament que volem buscar
     * @return l'allotjament que se cercava.
     */
    private Allotjament buscarAllotjament(String idAllotjament) {
        boolean trobatA = false;
        Allotjament allotjamentTrobat = null;
        Iterator<Allotjament> ita = llistaAllotjaments.iterator();

        while (ita.hasNext() && !trobatA) {
            // Recorre la llista d'allotjaments i mira si l'allotjament que es busca ja hi és o no
            Allotjament a = ita.next();

            if ((a.getId()).equals(idAllotjament)) {
                trobatA = true;
                allotjamentTrobat = a;
            }
        }
        return allotjamentTrobat;
    }

    /**
     * Busca si un client  existeix a la llista de clients.
     * @param dni el DNI del client que volem buscar
     * @return el client que se cercava.
     */
    private Client buscarClient(String dni){
        boolean trobatC = false;
        Client clientTrobat = null;
        Iterator<Client> itc = llistaClients.iterator();

        while (itc.hasNext() && !trobatC) {
            // Recorre la llista de clients i mira si el client que es busca ja hi és o no
            Client c = itc.next();

            if ((c.getDni()).equals(dni)) {
                trobatC = true;
                clientTrobat = c;
            }
        }
        return clientTrobat;
    }

    /**
     * Donada una data, retorna si és de temporada alta o baixa.
     * @param data la data que volem saber si és de temporada alta o baixa.
     * @return si la temporada és alta o baixa.
     */
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
