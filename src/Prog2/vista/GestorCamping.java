
package Prog2.vista;

import Prog2.model.Camping;
import Prog2.model.InAllotjament;

import java.time.LocalDate;
import java.util.Scanner;


/**
 * Classe per gestionar els allotjaments del Càmping del Mar.
 * @author lauraigual
 */
public class GestorCamping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcio, tipusA, i, anyE, mesE, diaE, anyS, mesS, diaS, habitacions = 0, placesPersones = 0, placesParquing = 0;
        boolean connexioElectrica, aireFred = false, terrassa = false, tv = false, serveisExtra = false, casaMascotes = false, terrassaBarbacoa = false;
        float metres;
        String dni, idAllotjament, nomClient, nomAllotjament, mida = "", codiWifi = "", material = "";
        LocalDate dataEntrada, dataSortida;
        Scanner sc = new Scanner(System.in);
        String [] opcions = {"Afegir allotjament nou", "Afegir client", "Afegir reserva"};
        String [] tipusAllotjament = {"Parcel·la", "Bungalow", "Bungalow Premium", "Glàmping", "Mobil-Home"};

        Camping campingMar = new Camping("Camping del Mar");
        omplirDadesModel(campingMar);
        ferReserves(campingMar);

        System.out.println("Benvingut/da a la interfície de gestió del càmping " + campingMar.getNom());

        // Mostrar el número total d'allotjaments del Càmping i el número d'allotjaments que estan operatius amb el següent missatge:
        // >> El número total d'allotjaments del Càmping és X dels quals X allotjaments estan operatius.
        //--------------------------------------------------------------------------------------------------
        // Per completar
        System.out.println("El número total d'allotjaments del Càmping és " + campingMar.getNumAllotjaments() + " dels quals " + campingMar.calculAllotjamentsOperatius() + " allotjaments estan operatius.");
        System.out.println("La mida total de les parcel·les del càmping és de " + campingMar.midaTotalParceles()+ "m²");
        // Mostrar l'allotjament amb estada mínima de la temporada alta més curta amb el següent missatge:
        // >> L'allotjament amb estada mínima de la temporada alta més curta és el següent:
        //--------------------------------------------------------------------------------------------------
        // Per completar
        System.out.println("L'allotjament amb estada mínima de la temporada alta més curta és el següent: " + campingMar.getAllotjamentEstadaMesCurta(InAllotjament.Temp.ALTA));

        do {
            for (i  = 0; i < opcions.length; i ++) {
                System.out.println((i + 1) + ". " + opcions[i]);
            }
            System.out.println("0. Sortir");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    System.out.println("Selecciona el tipus d'allotjament");
                    for (i = 0; i < tipusAllotjament.length; i ++) {
                        System.out.println((i + 1) + ". " + tipusAllotjament[i]);
                    }
                    tipusA = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introdueix el nom de l'allotjament: ");
                    nomAllotjament = sc.nextLine();
                    System.out.println("Introdueix l'ID de l'allotjament: ");
                    idAllotjament = sc.nextLine();

                    if (tipusA > 1 && tipusA < 6) {
                        System.out.println("Introdueix la mida de l'allotjament (petita, mitjana, gran): ");
                        mida = sc.nextLine();
                        System.out.println("Introdueix les habitacions de l'allotjament: ");
                        habitacions = sc.nextInt();
                        System.out.println("Introdueix les places de l'allotjament: ");
                        placesPersones = sc.nextInt();
                        sc.nextLine();
                    }

                    if (tipusA == 2 || tipusA == 3) {
                        System.out.println("Introdueix les places de pàrquing: ");
                        placesParquing = sc.nextInt();
                        System.out.println("Introdueix si l'allotjament té terrassa (true: sí, false: no): ");
                        terrassa = sc.nextBoolean();
                        System.out.println("Introdueix si l'allotjament té TV (true: sí, false: no): ");
                        tv = sc.nextBoolean();
                        System.out.println("Introdueix si l'allotjament té aire fred (true: sí, false: no): ");
                        aireFred = sc.nextBoolean();
                        sc.nextLine();
                    }

                    switch (tipusA) {
                        case 1:
                            System.out.println("Introdueix els metres de la parcel·la: ");
                            metres = sc.nextFloat();
                            System.out.println("Introdueix si l'allotjament té connexió elèctrica (true: sí, false: no): ");
                            connexioElectrica = sc.nextBoolean();
                            sc.nextLine();

                            campingMar.afegirParcela(nomAllotjament, idAllotjament, metres, connexioElectrica);
                            break;

                        case 2:
                            campingMar.afegirBungalow(nomAllotjament, idAllotjament, mida, habitacions, placesPersones, placesParquing, aireFred, terrassa, tv);
                            break;

                        case 3:
                            System.out.println("Introdueix el codi del Wifi del bungalow: ");
                            codiWifi = sc.nextLine();
                            System.out.println("Introdueix si l'allotjament té llençols i tovalloles (true: sí, false: no): ");
                            serveisExtra = sc.nextBoolean();
                            sc.nextLine();

                            campingMar.afegirBungalowPremium(nomAllotjament, idAllotjament, mida, habitacions, placesPersones, placesParquing, aireFred, terrassa, tv, serveisExtra, codiWifi);
                            break;

                        case 4:
                            System.out.println("Introdueix el material de la tenda: ");
                            material = sc.nextLine();
                            System.out.println("Introdueix si l'allotjament té casa per mascotes (true: sí, false: no): ");
                            casaMascotes = sc.nextBoolean();
                            sc.nextLine();

                            campingMar.afegirGlamping(nomAllotjament, idAllotjament, mida, habitacions, placesPersones, material, casaMascotes);
                            break;

                        case 5:
                            System.out.println("Introdueix si l'allotjament té terrassa amb barbacoa (true: sí, false: no): ");
                            terrassaBarbacoa = sc.nextBoolean();
                            sc.nextLine();

                            campingMar.afegirMobilHome(nomAllotjament, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);
                            break;

                        default:
                            System.out.println("Has introduït un valor incorrecte");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Introdueix el nom del nou client: ");
                    nomClient = sc.nextLine();
                    System.out.println("Introdueix el DNI del nou client: ");
                    dni = sc.nextLine();

                    campingMar.afegirClient(nomClient, dni);
                    break;

                case 3:
                    System.out.println("Introdueix el DNI del client: ");
                    dni = sc.nextLine();
                    System.out.println("Introdueix l'ID de l'allotjament: ");
                    idAllotjament = sc.nextLine();
                    System.out.println("Introdueix la data d'entrada (aaaa mm dd)");
                    anyE = sc.nextInt();
                    mesE = sc.nextInt();
                    diaE = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix la data d'de sortida (aaaa mm dd)");
                    anyS = sc.nextInt();
                    mesS = sc.nextInt();
                    diaS = sc.nextInt();
                    sc.nextLine();

                    dataEntrada = LocalDate.of(anyE, mesE, diaE);
                    dataSortida = LocalDate.of(anyS, mesS, diaS);

                    try {
                        campingMar.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
                    } catch (ExcepcioReserva e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default: break;
            }

        } while (opcio != 0);

        System.out.println("S'ha tancat la sessió correctament");
       
    }

    /**
     * Mètode de classe per afegir parcel·les, bungalows, bungalows premium, glampings, mobil-home i clients al càmping.
     * @param camping L'objecte de tipus Camping que anem a omplir
     */
    private static void omplirDadesModel(Camping camping){


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "100P";

        float metres = 64.0f;
        boolean connexioElectrica = true;

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);

        nom = "Parcel·la Sud";
        idAllotjament = "101P";

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);


        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Est";
        idAllotjament = "102B";
        String mida = "Mitjana";

        int habitacions =2;
        int placesPersones = 6;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;


        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        nom = "Bungalow Oest";
        idAllotjament = "103B";
        habitacions =2;
        placesPersones = 4;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = true;

        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Nord";
        idAllotjament = "104BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 2;
        terrassa = true;
        tv= false;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        nom = "Bungallow Sud";
        idAllotjament = "105BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = false;
        serveisExtra = true;
        codiWifi = "CampingDelMarBP2";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "106G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        nom = "Glamping Sud";
        idAllotjament = "107G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        material = "Tela";
        casaMascota = false;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Nord";
        idAllotjament = "108MH";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        boolean terrassaBarbacoa = true;


        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);

        nom = "Mobil-Home Sud";
        idAllotjament = "109MH";
        mida = "Mitjana";
        habitacions =2;
        placesPersones = 4;
        terrassaBarbacoa = false;

        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);


        // Afegir clients:
        //------------------------------

        String nomClient="Patricia Fernandez";
        String dni="12345678X";
        camping.afegirClient(nomClient, dni);

        nomClient = "Lluís Plans";
        dni="78659101A";
        camping.afegirClient(nomClient, dni);

    }


    /**
     * Mètode per fer reserves d'allotjaments.
     * @param camping
     */
    private static void ferReserves(Camping camping){
        
        // Per completar:
        
        // 1. Afegeix una reserva pel client amb DNI "12345678X" de l'allotjament amb identificador "100P"
        // amb la data d'entrada 20 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Declara les variables de tipus String idAllotjament i dni.
        // Per completar
        String idAllotjament;
        String dni;
        LocalDate dataEntrada;
        LocalDate dataSortida;
        // Assigna els valors corresponents.
        // Per completar
        idAllotjament = "100P";
        dni = "12345678X";
        // Crear una LocalDate per definir la data de la reserva.
        // Per completar
        dataEntrada = LocalDate.of(2026, 2, 20);
        dataSortida = LocalDate.of(2026, 2, 28);

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        // Per completar
        try {
            camping.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }
        // 2. Afegeix una reserva pel client amb DNI "78659101A" de l'allotjament amb identificador "100P"
        // amb la data d'entrada 25 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Assigna els nous valors a les variables
        // Per completar
        dni = "78659101A";
        idAllotjament = "100P";
        dataEntrada = LocalDate.of(2026, 2, 25);
        dataSortida = LocalDate.of(2026, 2, 28);
        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        // Per completar
        try {
            camping.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }
        // 3. Afegeix una reserva pel client amb DNI "789101A" de l'allotjament amb identificador "300Z"
        // amb la data d'entrada 25 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Assigna els nous valors a les variables.    
        // Per completar
        dni = "789101A";
        idAllotjament = "300Z";
        dataEntrada = LocalDate.of(2026, 2, 25);
        dataSortida = LocalDate.of(2026, 2, 28);
        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        // Per completar
        try {
            camping.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }
    }
}
