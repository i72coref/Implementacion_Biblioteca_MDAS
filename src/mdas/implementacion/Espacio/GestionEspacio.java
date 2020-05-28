package mdas.implementacion.Espacio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class GestionEspacio {
	
	public boolean añadirEspacio() {
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
		int id;
		String ubicacion, aforo, nombre;
		int proyector, pizarra;
		String categoriaEspacio; //AULA,SALA_USO_MULTIPLE,LABORATORIO
		FileWriter fichero = null;
        BufferedWriter pw = null;

	    String ficheroUsuarios = "Aulas.csv";
	    
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
		
		fichero = new FileWriter("files" + File.separator + ficheroUsuarios, true);
        pw = new BufferedWriter(fichero);
        pw.write(nombre + ";" + ubicacion + ";" + categoriaEspacio + ";" + aforo + ";" + proyector + ";" + pizarra + "\n");
        pw.close();

		return true;
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Error al Añadir el Espacio");
		return false;
		
	}//Fin añadirEspacio
}
