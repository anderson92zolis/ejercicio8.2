import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Hotel> arrayListHotels = new ArrayList<Hotel>();  // Create an ArrayList object

    public static void main(String[] args) {
      System.out.println("Hello World");

    }

    public static void msmSiExisteOno(String nomHotel){
        if (existeHotel(nomHotel) != -1){
            System.out.println("El hotel " +nomHotel+ "EXISTE!" );
        } else {
            System.out.println("El hotel " +nomHotel+ " NO EXISTE! CREALO" );
        }
    }

    public static int existeHotel(String nomHotel){
        int index=0;
        int indexBuscar= -1;
        while(index<arrayListHotels.size() && indexBuscar == -1) {
            if(arrayListHotels.get(index).getNom()== nomHotel) { 
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