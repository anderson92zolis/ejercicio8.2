public class Hotel {
		
	private String nom;
	private int nombreHabitacions;
	private int nombrePlantes;
	private int superfícieTotalHotel;
		
	//--------------------------Constructor------------------------
	public Hotel(String nom, int nombreHabitacions, 
				int nombrePlantes, int superfícieTotalHotel) {
		this.nom=nom;
		this.nombreHabitacions= nombreHabitacions;
		this.nombrePlantes = nombrePlantes;
		this.superfícieTotalHotel=superfícieTotalHotel;
	}

    // getter
    public String getNom(){
        return nom;
    }

    public int getNombreHabitacions(){
        return nombreHabitacions;
    }

    public int getNombrePlantes(){
        return nombrePlantes;
    }

    public int getSuperficieTotalHotel(){
        return superfícieTotalHotel;
    }
    //setters
    public void setNom(String nom){
        this.nom=nom;
    }

    public void setNombreHabitacions(int nombreHabitacions){
        this.nombreHabitacions=nombreHabitacions;
    }

    public void setNombrePlantes(int nombrePlantes){
        this.nombrePlantes=nombrePlantes;
    }

    public void setSuperfícieTotalHotel(int superfícieTotalHotel){
        this.superfícieTotalHotel=superfícieTotalHotel;
    }
    // methods
    public void calcularManteniment(){
        System.out.println("persones són necessàries per atendre el servei d’habitacions de l’hotel, "+ nom + " son " + (double) nombreHabitacions/20);
        System.out.println("el cost total destinat al servei: "+ (double) nombreHabitacions/20 *(1500) +" €/mes");
    }

    public String toString(){
        return " nom d'Hotel: "+ nom +" \n "+
                " nombre d'habitacions: " + nombreHabitacions +" \n "+
                " nombre d'Plantes: " + nombrePlantes + " \n " + 
                " nombre superfícieTotalHotel: " + nombrePlantes;
    }

}