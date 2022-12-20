import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Hotel> arrayListHotels = new ArrayList<Hotel>();  // Create an ArrayList object

    public static void main(String[] args) {
      Hotel hotel1= new Hotel("A", 1, 2, 3);
      arrayListHotels.add(hotel1);
      
      msmSiExisteOno("CARLO");
        
      menu();
    }

    public static void menu(){
       int choice;
        do { choice= askParametroReturnInteger("\n\t Per a afegir hotel introdueixi-> 1"
            + "\n\t Per a donar de baixa un hotel introdueixi-> 2"
            + "\n\t Per a veure hotel introdueixi-> 3"
            + "\n\t Per a modificar un hotel introdueixi-> 4"
            + "\n\t Per a imprimir tots els Hotels disponibles -> 5"
            + "\n\t Per a sortir del programa introdueixi-> 0"
            + "\n\n\t Introdueix elecció: ");
            switch(choice) {
                case 1:
                    crearHotel();
                  break;
                case 2:
                    eliminarHotel();
                    break;
                case 3:
                    veureHotel();
                    break;
                case 4:
                    modificarHotel();
                    break;
                case 5:
                    System.out.println(arrayListHotels.toString());
                    break;
                default:
                  // code block
              }
                      
    } 
    while(choice != 0);   
    }

    public static void crearHotel(){
        String nomHotel= askParametroReturnString("Escriure nom d'Hotel para crear: ");
        msmSiExisteOno(nomHotel);
        if (existeHotel(nomHotel)==-1){
            int nombreHabitacions= askParametroReturnInteger("Introduex nombre de Habitacions: ");
            int nombrePlantes= askParametroReturnInteger("Introduex nombre de Plantes: ");
            int superfícieTotalHotel= askParametroReturnInteger("Introduex superficie total d'Hotel: ");
            Hotel nuevoHotel = new Hotel(nomHotel, nombreHabitacions,nombrePlantes, superfícieTotalHotel);
            arrayListHotels.add(nuevoHotel);  
        }
    } 

    public static void eliminarHotel(){
        String nomHotel= askParametroReturnString("Escriure nom d'Hotel a eliminar: ");
        msmSiExisteOno(nomHotel);
        if (existeHotel(nomHotel) !=-1){
            System.out.println("Se eliminará del la base de datos");
            arrayListHotels.remove(existeHotel(nomHotel));      
        }
    } 

    public static void veureHotel(){
        String nomHotel= askParametroReturnString("Escriure nom d'Hotel para revisar sus datos: ");
        msmSiExisteOno(nomHotel);
        if (existeHotel(nomHotel) !=-1 ){
            System.out.println(arrayListHotels.get(existeHotel(nomHotel)).toString());
            arrayListHotels.get(existeHotel(nomHotel)).calcularManteniment();  
        };
    } 

    public static void modificarHotel(){
        String nomHotel= askParametroReturnString("Escriure nom d'Hotel para MODIFICAR datos: ");
        msmSiExisteOno(nomHotel);
        if (existeHotel(nomHotel) !=-1 ){
            int elecio = askParametroReturnInteger ( "La propietat que desitgis modificar són! "
            + "\n\t Modificar el nombre d’habitacions-> 2 "
            + "\n\t El nombre de plantes-> 3 "
            + "\n\t La superfície total de l’hotel-> 4 "
            + "\n\t Introdueix elecció a modificar: ");

            switch(elecio){
                case 2:
                    int nombreHabitacions = askParametroReturnInteger("Escriure nombre de las noves Habitacions d'Hotel: ");
                    arrayListHotels.get(existeHotel(nomHotel)).setNombreHabitacions(nombreHabitacions);
                     break;
                case 3:
                    int nombrePlantes= askParametroReturnInteger("Escriure nombre de las noves Plantes d'Hotel: ");
                    arrayListHotels.get(existeHotel(nomHotel)).setNombrePlantes(nombrePlantes);
                    break;
                case 4:
                    int novaSuperficie= askParametroReturnInteger("Escriure nombre de las superficie d'Hotel: ");
                    arrayListHotels.get(existeHotel(nomHotel)).setSuperfícieTotalHotel(novaSuperficie);
                    break;
                default:
                    System.out.println(" Opcio invalida, saliendo del subMenu modificarHotel() ");
            } 
        };
    }

    public static void msmSiExisteOno(String nomHotel){
        if (existeHotel(nomHotel) != -1){
            System.out.println("El hotel " +nomHotel+ " EXISTE! " );
        } else {
            System.out.println("El hotel " +nomHotel+ " NO EXISTE! CREALO " );
        }
    }

    public static int existeHotel(String nomHotel){
        int index=0;
        int indexBuscar= -1;
        while(index<arrayListHotels.size() && indexBuscar == -1) {
            if(arrayListHotels.get(index).getNom().equalsIgnoreCase(nomHotel)) { 
                indexBuscar=index;
                } 
            index++;	
        }
        return indexBuscar;        
    } 

    public static String askParametroReturnString(String notas) {
		System.out.print(notas);		
		Scanner user = new Scanner(System.in); // Import the Scanner class
		String parametroSalida= user.nextLine();
		return parametroSalida;
	}

	public static int askParametroReturnInteger(String notas) {
		System.out.print(notas);
		Scanner user =new Scanner(System.in); // Import the Scanner class
		int parametroSalida= user.nextInt();
		return parametroSalida;
	}
  }