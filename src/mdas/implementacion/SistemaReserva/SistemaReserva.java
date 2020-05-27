package mdas.implementacion.SistemaReserva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SistemaReserva {

public void reservarAula(String userOnline) {//He pensado en que tengamos una ilsta con las posibilidades y que en funcion de las respuestas que nos den les asignmos ese aula, que estaria en un doc
		

	    try {
	    	//meter comprobacion para ver si esta en lista negra o no
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util

	    	int aforoRequerido = 0, respuestaProyector = 0, respuestaPizarra = 0;
	    	System.out.println("¿Que aforo necesitas para el aula? (indicar numero)");
	    	
	    	aforoRequerido = entradaEscaner.nextInt();
			entradaEscaner.nextLine();//Con esto limpiamos el buffer, ya que next int coge los enteros que encuentre pero se deja el salto de linea \n, por tanto, el siguiente nextLine se come el salto de linea y genera problemas
				    	
	    	System.out.println("¿Necesitas proyector? 1->Si 2->No");
	    	
	    	respuestaProyector = entradaEscaner.nextInt();
			entradaEscaner.nextLine();//Con esto limpiamos el buffer, ya que next int coge los enteros que encuentre pero se deja el salto de linea \n, por tanto, el siguiente nextLine se come el salto de linea y genera problemas
				    	
	    	System.out.println("¿Necesitas pizarra? 1->Si 2->No");
	    	
	    	respuestaPizarra = entradaEscaner.nextInt();
			entradaEscaner.nextLine();//Con esto limpiamos el buffer, ya que next int coge los enteros que encuentre pero se deja el salto de linea \n, por tanto, el siguiente nextLine se come el salto de linea y genera problemas
			
	    	//ahora lo mandamos a otra funcion para hacer el check con el doc de aulas.txt
			comprobarAulas(aforoRequerido,respuestaProyector,respuestaPizarra, userOnline);
			
			
	    }catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	public void comprobarAulas(int aforoRequerido, int respuestaProyector, int respuestaPizarra, String userOnline) {
		
		
	    try {
	    	
			int aforoAula = 0, proyectorAula = 0, pizarraAula = 0;
	    	
	    	String ficheroAulas = "Aulas.csv";
			BufferedReader readerAulas = new BufferedReader(new FileReader("files" + File.separator + ficheroAulas));

	        System.out.println("Buscamos aulas disponibles..");
	        String line = "";
	        while((line = readerAulas.readLine()) != null){
	        	//Nombre;ubicacion;aforo;proyector(1 es si, 2 es no);pizarra
	        	
	            String[] array = line.split(";");
	            String part1 = array[0]; //nombre Aula
	    		String part2 = array[1]; //ubicacion
	    		String part3 = array[2]; //aforo
	    		String part4 = array[3]; //proyector
	    		String part5 = array[4]; //pizarra
	    		
	    		System.out.println(part1);
	    		
	    		aforoAula = Integer.parseInt(part3);
	    		proyectorAula = Integer.parseInt(part4);
	    		pizarraAula = Integer.parseInt(part5);

	    		if(aforoAula > aforoRequerido && proyectorAula == respuestaProyector && pizarraAula == respuestaPizarra) {
	    			String fechaDisponible = comprobarDisponibilidadDeFecha(part1);
	    			System.out.println("El aula asignada es " + part1 + " el día " + fechaDisponible + " ubicada en " + part2);
	    			guardarReserva(userOnline, part1, fechaDisponible);
	    			readerAulas.close();
	    			return;//Salgo de la funcion
	    		}
	        }
	        
	        System.out.println("No se ha podido encontrar ningun aula disponible con las especificaciones dadas");
	        readerAulas.close();
	        
	    }catch (Exception e) {
			// TODO: handle exception
		}
	    
		
	}
	
	public void guardarReserva(String userAlumnoReserva, String nombreAula, String fecha) {
		FileWriter fichero = null;
        BufferedWriter pw = null;
		try {

			System.out.println("Guardando reserva...");
			String ficheroReservas = "Reservas.csv";
			fichero = new FileWriter("files" + File.separator + ficheroReservas, true);
            pw = new BufferedWriter(fichero);
            pw.write(userAlumnoReserva + ";" + fecha + ";" + userAlumnoReserva + ";" + nombreAula + "\n");
            pw.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void consultarReservas() {
		
		try {
	
			String ficheroReservas= "Reservas.csv";
			BufferedReader readerStudent = new BufferedReader(new FileReader("files" + File.separator + ficheroReservas));
	        
	        String line = "";
	        while((line = readerStudent.readLine()) != null){        	
	        	
	        	//Alumno alTemp = new Alumno(0,null,null,0);
	            String[] array = line.split(";");
	            String part1 = array[0]; //Alumno
	    		String part2 = array[1]; //Fecha
	    		String part3 = array[2]; //Responsable
	    		String part4 = array[3]; //Aula
	    		
	    		System.out.println("El alumno " + part1 + " ha realizado una reserva para el día " + part2 + " del aula " + part4 + " y como responsable " + part3);
	    		
	        }
	        
	        readerStudent.close();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String comprobarDisponibilidadDeFecha(String aulaDeseada) {
		
		try {
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
			Boolean check = false;
			System.out.println("Escriba la fecha para la reserva: dd/MM/yyyy");
			String fechaDeseada = entradaEscaner.nextLine();
			
			check = comprobarFechaConFicheroDeReserva(fechaDeseada,aulaDeseada);
			while(!check) {
				System.out.println("Escoja otra fecha");
				fechaDeseada = entradaEscaner.nextLine();
				check = comprobarFechaConFicheroDeReserva(fechaDeseada,aulaDeseada);
			}
			
			return fechaDeseada;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
	
	public Boolean comprobarFechaConFicheroDeReserva(String fechaDeseada, String aulaDeseada) {

	    
	    try {
	    	
	    	String ficheroReservas = "Reservas.csv";
			BufferedReader readerReservas = new BufferedReader(new FileReader("files" + File.separator + ficheroReservas));

	        System.out.println("Comprobando que no coincidan fechas reservadas previamente...");
	        String line = "";
	        while((line = readerReservas.readLine()) != null){
	        	
	            String[] array = line.split(";");
	            String part1 = array[0]; //Alumno
	    		String part2 = array[1]; //Fecha
	    		String part3 = array[2]; //Responsable
	    		String part4 = array[3]; //Aula

	    		if(aulaDeseada.equals(part4) && fechaDeseada.equals(part2)) {
	    			
	    			readerReservas.close();
	    	        System.out.println("No se ha podido encontrar ningun aula disponible con las especificaciones dadas");
	    			return false;//Salgo de la funcion
	    		}
	        }
	        System.out.println("Fecha disponible");
	        readerReservas.close();
	        return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

		
	}
	
}
