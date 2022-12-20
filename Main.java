import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Hotel> arrayListHotels = new ArrayList<Hotel>();  // Create an ArrayList object

    public static void main(String[] args) {
      Hotel hotel1= new Hotel("MONTES DE CARLO", 60, 6, 40000);
      arrayListHotels.add(hotel1);
      
      msmSiExisteOno("MONTES DE CARLO");
      crearHotel();
      eliminarHotel();
      veureHotel();
      System.out.println(arrayListHotels.toString());
    }

    public static void veureHotel(){
        String nomHotel= askParametroReturnString("Escriure nom d'Hotel para revisar sus datos: ");
        msmSiExisteOno(nomHotel);
        if (existeHotel(nomHotel) !=-1 ){
            System.out.println(arrayListHotels.get(existeHotel(nomHotel)).toString());  
        };
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