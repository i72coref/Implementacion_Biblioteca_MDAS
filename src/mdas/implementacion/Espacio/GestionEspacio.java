package mdas.implementacion.Espacio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class GestionEspacio {
	
    /** 
     * Añade un Espacio al fichero: Aulas.csv con los Datos introducidos por el Usuario Administrador.
     * @return True si se añade el archivo correctamente.
     * @return False en caso contrario.
     */
	
	public boolean añadirEspacio() {
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util

		String ubicacion, aforo, nombre;
		int proyector, pizarra;
		String categoriaEspacio; //AULA,SALA_USO_MULTIPLE,LABORATORIO
		FileWriter fichero = null;
        BufferedWriter pw = null;

	    String ficheroAulas = "Aulas.csv";
	    
	    try{

		System.out.println("Escriba el nombre de la Sala: ");
		nombre=entradaEscaner.nextLine();
		System.out.println("Escriba el Aforo de la Sala: ");
		aforo=entradaEscaner.nextLine();
		System.out.println("Escriba el Tipo de Sala: AULA,SALA_USO_MULTIPLE,LABORATORIO: ");
		categoriaEspacio=entradaEscaner.nextLine();
		System.out.println("Escriba el Edificio al que pertenece: ");
		ubicacion=entradaEscaner.nextLine();
		System.out.println("Escribe si tiene Pizarra: 1->Si 2->No ");
		pizarra=Integer.parseInt(entradaEscaner.nextLine());
		System.out.println("Escribe si tiene Proyector: 1->Si 2->No");
		proyector=Integer.parseInt(entradaEscaner.nextLine());
		
		fichero = new FileWriter("files" + File.separator + ficheroAulas, true);
        pw = new BufferedWriter(fichero);
        pw.write(nombre + ";" + ubicacion + ";" + aforo + ";" + proyector + ";" + pizarra +";"+ categoriaEspacio + "\n");
        pw.close();
        
        entradaEscaner.close();
		return true;
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Error al Añadir el Espacio");
		return false;
		
	}//Fin añadirEspacio
	
    /** 
     * Muestra por pantalla todos los Espacios disponibles en el fichero: Aulas.csv
     */
	public void mostrarEspacios() {
		
		try {
			
			String ficheroAulas= "Aulas.csv";
			BufferedReader readerAulas = new BufferedReader(new FileReader("files" + File.separator + ficheroAulas));
	        
			System.out.println("Aulas Disponibles: \n"
							+ "-------------------\n");
			
	        String line = "";
	        while((line = readerAulas.readLine()) != null){        	
	        	
	        	//Alumno alTemp = new Alumno(0,null,null,0);
	            String[] array = line.split(";");
	            String part1 = array[0]; //Nombre
	    		String part2 = array[1]; //Edificio
	    		String part3 = array[2]; //Aforo
	    		
	    		/*Se guardan Proyector y Pizarra aunque no se usen, 
	    		 * por si se contemplan usar en el futuro.
	    		String part4 = array[3]; //Proyector
	    		String part5 = array[4]; //Pizarra */
	    		
	    		String part6 = array[5]; //Tipo Sala	
	    		System.out.println("Nombre: "+part1+", Edificio: "+ part2+", Aforo: "+part3+", Tipo de Sala: "+part6+"\n");
	        }
	        
	        
	        readerAulas.close();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}